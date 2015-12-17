angular.module('behavior', []);
angular.module('behavior').controller('behaviorController', function (UserService, $scope, $http) {

    $scope.behavior = {};
    $scope.account = {};
    $scope.studentShow = UserService.user.student;
    $scope.keyword = "";
    $scope.currentPage = 0;
    $scope.studentOfTeacher = {};
    
    $scope.page = 0;
    $scope.size = '10';
    var totalRow = 0;
    var totalPage = 0;
    
    $scope.savebehaviorerror = {};
    
    $scope.behaviorshowname = function () {
        if ($scope.account.dtype == 'Teacher'||$scope.account.dtype == 'Parent') {
            return  true;
        } else {
            return false;
        }
    };

    $scope.checkTeacherLogin = function () {
        if ($scope.account.dtype === 'Teacher') {
            $scope.behavior.teacher = $scope.account;
            return true;
        } else {
            $scope.behavior.student = $scope.account;
            $scope.behavior.teacher = $scope.account.teacher;
            return false;
        }
    };

    getAccountLogin();
    function getAccountLogin() {
        $http.get('/startpageuser').success(function (data) {
            $scope.account = data;
            getBehavior();
            getStudentOfteacher();
        });
    }

    $scope.saveBehavior = function () {
        $scope.behavior.teacher = $scope.account;
        $http.post('/savebehavior', $scope.behavior).success(function (data) {
            $('#complete-dialog-savebehaviors').modal('show');
            getBehavior();
            console.log(data);
            $scope.clear();
        }).error(function (data) {
            $scope.savebehaviorerror = data;
        });
    };

    function getStudentOfteacher() {
        var studentOrTeacher = {};
        if ($scope.account.dtype === 'Teacher') {
            studentOrTeacher = $scope.account.id;
        } else {
            studentOrTeacher = $scope.account.teacher.id;
        }
        $http.post('/getidteacher', studentOrTeacher).success(function (data) {
            $scope.studentOfTeacher = data;
        });
    }

    $scope.editBehavior = function (u) {
        $scope.behavior = u;
    };
    
    $scope.delete = {};
    $scope.clickDelete = function (advise) {
        $scope.delete = advise;
    };
    
    $scope.clear = function () {
        $scope.behavior = {};
    };

    $scope.delBehavior = {};
    $scope.deleteBehavior = function (delBehavior) {
        $http.post('/deletebehavior', delBehavior).success(function (data) {
            getBehavior();
        }).error(function (data) {
            getError();
        });
    };

    $scope.behaviorshow = {};
    function getBehavior() {
        var getBehaviorForAccount = {};
        getBehaviorForAccount.keyWord = $scope.account.name;
        getBehaviorForAccount.searchBy = $scope.account.dtype;
        $http.post('/getbehavior', getBehaviorForAccount,{params: {page: $scope.page, size: $scope.size}}).success(function (data) {
            $scope.behaviorshow = data;
            console.log('..........................' + data);
        }).error(function (data) {
            getError();
        });
    }
    ;

    function getSuccess() {
        alert('Save Success');
    }

    function getError() {
        alert('Error');
    }
/////////////////////////////////////////////////////////datepicker
    $('.datepicker-custom').datepicker({
        changeYear: true,
        yearRange: '-100:+100',
        dateFormat: 'yy-mm-dd'
    });
////////////////////////////////////////////////////////////////////
///////////////////////////////////////////Paging 
    $scope.selectSizeBehavior = function () {
        $scope.page = 0;
        getBehavior();
        getTotalRow();
    };

    getTotalRow();
    function getTotalRow() {
        $http.get('/gettotalbehavior').success(function (data) {
            totalRow = data;
            findPage();
            if ($scope.page == 0) {
                $('#prepage , #firstpage').addClass('disabled');
            }
            if ($scope.page == totalPage - 1) {
                $('#nextpage , #finalpage').addClass('disabled');
            }

        });
    }

    function findPage() {
        var result = parseInt(totalRow / $scope.size);
        if ((totalRow % $scope.size) != 0) {
            result++;
        }
        totalPage = result;
    }

    $scope.firstPageBehavior = function () {
        if (!$('#-page').hasClass('disabled')) {
            $scope.page = 0;
            getBehavior();
            $('#firstpagebehavior').addClass('disabled');
            $('#prepagebehavior').addClass('disabled');
            $('#nextpagebehavior').removeClass('disabled');
            $('#finalpagebehavior').removeClass('disabled');
        }
    };

    $scope.prePageBehavior = function () {
        if (!$('#prepagebehavior').hasClass('disabled')) {
            $scope.page--;
            getBehavior();
            if ($scope.page == 0) {
                $('#firstpagebehavior').addClass('disabled');
                $('#prepagebehavior').addClass('disabled');
            }
            $('#nextpagebehavior').removeClass('disabled');
            $('#finalpagebehavior').removeClass('disabled');
        }
    };

    $scope.nextPageBehavior = function () {
        if (!$('#nextpagebehavior').hasClass('disabled')) {
            $scope.page++;
            getBehavior();
            if ($scope.page == totalPage - 1) {
                $('#nextpagebehavior').addClass('disabled');
                $('#finalpagebehavior').addClass('disabled');
            }
            $('#firstpagebehavior').removeClass('disabled');
            $('#prepagebehavior').removeClass('disabled');
        }
    };

    $scope.finalPageBehavior = function () {
        if (!$('#finalpagebehavior').hasClass('disabled')) {
            $scope.page = totalPage - 1;
            getBehavior();
            $('#nextpagebehavior').addClass('disabled');
            $('#finalpagebehavior').addClass('disabled');
            $('#firstpagebehavior').removeClass('disabled');
            $('#prepagebehavior').removeClass('disabled');
        }
    };


    //////////////////////////////////////////////////////////
    $scope.behaviorSearch = function () {
        $http.post('/searchStudentInBehavior', $scope.keyword).success(function (data) {
            $scope.behaviorshow = data;
        });
    };

    getStudent();
    $scope.student = {};
    function getStudent() {
        $http.post('/getstudent', 'Student').success(function (data) {
            $scope.student = data;
        }).error(function (data) {

        });
    }
    ;

    $scope.selectStudent = function (student) {
        $scope.behavior.student = student;
        $scope.studentShow = student;
    };

    $scope.studentSearch = function () {
        console.log($scope.keyword);
        $http.post('/student/search', $scope.keyword).success(function (data) {
            $scope.student = data;
        });
    };

    $scope.clickStudent = function () {
        $('#complete-student').modal('show');
    };


    $scope.dowloads = function (be) {
        location.href = '/getfilebehavior/' + be.fileUpload.id;

    };

    $scope.file;
    $scope.saveFileBehavior = function () {
        var fd = new FormData();
        fd.append('files', $scope.file);
        $http.post('/savefilebehavior', fd, {
            transformRequest: angular.identity,
            headers: {'Content-Type': undefined}
        }).success(function (data) {
            console.log(data + 'fileeeeeeeeeeeeee');
            $scope.behavior.fileUpload = data;
        });
    };

});



app.directive('fileModel', function ($parse) {
    return {
        restrict: 'A',
        link: function (scope, element, attrs) {
            var model = $parse(attrs.fileModel);
            var modelSetter = model.assign;
            element.bind('change', function () {
                scope.$apply(function () {
                    modelSetter(scope, element[0].files[0]);
                });
            });
        }
    };
});

app.directive('customOnChange', function () {
    return {
        restrict: 'A',
        link: function (scope, element, attrs) {
            var onChangeHandler = scope.$eval(attrs.customOnChange);
            element.bind('change', onChangeHandler);
        }
    };
});