angular.module('advise', []);
angular.module('advise').controller('adviseController', function (UserService, $scope, $http) {

    $scope.advise = {};
    $scope.account = {};
    $scope.studentShow = UserService.user.student;
    $scope.keyword = "";
    $scope.currentPage = 0;
    $scope.studentOfTeacher = {};
    $scope.page = 0;
    $scope.size = '10';
    var totalRow = 0;
    var totalPage = 0;

    $scope.advisorshowname = function () {
        if ($scope.account.dtype == 'Teacher') {
            return  true;
        } else {
            return false;
        }
    };

    $scope.checkTeacherLogin = function () {
        if ($scope.account.dtype === 'Teacher') {
            $scope.advise.teacher = $scope.account;
            return true;
        } else {
            $scope.advise.student = $scope.account;
            $scope.advise.teacher = $scope.account.teacher;
            return false;
        }
    };

    getAccountLogin();
    function getAccountLogin() {
        $http.get('/startpageuser').success(function (data) {
            $scope.account = data;
            getAdvise();
            getStudentOfteacher();

        });
    }

    $scope.saveAdvise = function () {
        $http.post('/saveadvise', $scope.advise).success(function (data) {
            getSuccess();
            $scope.clear();
            getAdvise();
        }).error(function (data) {
            getError();
        });
    };

    function getStudentOfteacher() {
        var studentOrTeacher = {};
        if ($scope.account.dtype === 'Teacher') {
            studentOrTeacher = $scope.account.id;
        } else {
            studentOrTeacher = $scope.account.teacher.id;
        }
        $http.post('/getstudentofteacher', studentOrTeacher).success(function (data) {
            $scope.studentOfTeacher = data;
        });
    }

    $scope.adviseshow = {};
    function getAdvise() {
        var getAdviseForAccount = {};
        getAdviseForAccount.searchBy = $scope.account.dtype;
        getAdviseForAccount.keyWord = $scope.account.name;
        $http.post('/getadvisee', getAdviseForAccount, {params: {page: $scope.page, size: $scope.size}}).success(function (data) {
            $scope.adviseshow = data;

            console.log('..........................' + data);
        }).error(function (data) {
            getError();
        });
    }
    ;
    ///////////////////////////////////////////Paging Advisor
    $scope.selectSizeAdvisor = function () {
        $scope.page = 0;
        getAdvise();
        getTotalRow();
    };

    getTotalRow();
    function getTotalRow() {
        $http.get('/gettotaladvisor').success(function (data) {
            totalRow = data;
            findPage();
            if ($scope.page == 0) {
                $('#prepageadvisor , #firstpageadvisor').addClass('disabled');
            }
            if ($scope.page == totalPage - 1) {
                $('#nextpageadvisor , #finalpageadvisor').addClass('disabled');
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
    
    $scope.firstPageAdvise = function () {
        if (!$('#-page').hasClass('disabled')) {
            $scope.page = 0;
            getAdvise();
            $('#firstpageadvisor').addClass('disabled');
            $('#prepageadvisor').addClass('disabled');
            $('#nextpageadvisor').removeClass('disabled');
            $('#finalpageadvisor').removeClass('disabled');
        }
    };

    $scope.prePageAdvise = function () {
        if (!$('#prepageadvisor').hasClass('disabled')) {
            $scope.page--;
            getAdvise();
            if ($scope.page == 0) {
                $('#firstpageadvisor').addClass('disabled');
                $('#prepageadvisor').addClass('disabled');
            }
            $('#nextpageadvisor').removeClass('disabled');
            $('#finalpageadvisor').removeClass('disabled');
        }
    };

    $scope.nextPageAdvise = function () {
        if (!$('#nextpageadvisor').hasClass('disabled')) {
            $scope.page++;
            getAdvise();
            if ($scope.page == totalPage - 1) {
                $('#nextpageadvisor').addClass('disabled');
                $('#finalpageadvisor').addClass('disabled');
            }
            $('#firstpageadvisor').removeClass('disabled');
            $('#prepageadvisor').removeClass('disabled');
        }
    };

    $scope.finalPageAdvise = function () {
        if (!$('#finalpageadvisor').hasClass('disabled')) {
            $scope.page = totalPage - 1;
            getAdvise();
            $('#nextpageadvisor').addClass('disabled');
            $('#finalpageadvisor').addClass('disabled');
            $('#firstpageadvisor').removeClass('disabled');
            $('#prepageadvisor').removeClass('disabled');
        }
    };
    
    
    //////////////////////////////////////////////////////////
    getAdviseCategory();
    $scope.advisecateshow = {};
    function getAdviseCategory() {
        $http.get('/getcategory').success(function (data) {
            $scope.advisecateshow = data;
        }).error(function (data) {
            getError();
        });
    }
    ;

///////////////////////////////////////////////////////////////////
    $scope.editAdvise = function (u) {
        $scope.advise = u;
    };

    $scope.delAdvise = {};
    $scope.deleteAdvise = function (delAd) {
        $http.post('/deleteadvise', delAd).success(function (data) {
            getAdvise();
        }).error(function (data) {
            getError();
        });
    };

    $scope.clickUpdate = function (updateAdvise) {
        $scope.advise = updateAdvise;
    };

    $scope.clear = function () {
        $scope.advise = {};
    };

    function getSuccess() {
        alert('Save Success');
    }
    function getError() {
        alert('Error');
    }
///////////////Setting Calendar////////////////////////////////////
    $('.datepicker-custom').datepicker({
        changeYear: true,
        yearRange: '-100:+100',
        dateFormat: 'yy-mm-dd'
    });
///////Search StudentSearchService////////////////////////////////
    $scope.adviseSearch = function () {
        $http.post('/searchStudentInAdvise', $scope.keyword).success(function (data) {
            $scope.adviseshow = data;
        });
    };

    $scope.selectStudent = function (student) {
        $scope.advise.student = student;
        $scope.studentShow = student;
    };

    $scope.studentSearch = function () {
        console.log($scope.keyword);
        $http.post('/student/search', $scope.keyword).success(function (data) {
            $scope.student = data;
            console.log(data);
        });
    };
//// Paging Select Student///////////////////////////////////////
//    countStudent();
//    function countStudent() {
//        $http.get('/countstudent').success(function (data) {
//            totalStudent = data;
//            totalPageStudent();
//            console.log(totalPage);
//        });
//
//        function totalPageStudent() {
//            totalPage = parseInt(totalStudent / 10);
//            if ((totalStudent % 10) != 0) {
//                totalPage++;
//            }
//            if ($scope.currentPage == 0) {
//                $('#first-page').addClass('disabled');
//                $('#pre-page').addClass('disabled');
//                $('#next-page').addClass('disabled');
//                $('#final-page').addClass('disabled');
//            }
//            if (totalPage > 1) {
//                $('#next-page').removeClass('disabled');
//                $('#final-page').removeClass('disabled');
//            }
//        }
//    }
//
//    $scope.firstPage = function () {
//        if (!$('#first-page').hasClass('disabled')) {
//            $scope.currentPage = 0;
//            getParent();
//            $('#first-page').addClass('disabled');
//            $('#pre-page').addClass('disabled');
//            $('#next-page').removeClass('disabled');
//            $('#final-page').removeClass('disabled');
//        }
//    };
//
//    $scope.prePage = function () {
//        if (!$('#pre-page').hasClass('disabled')) {
//            $scope.currentPage--;
//            getParent();
//            if ($scope.currentPage == 0) {
//                $('#first-page').addClass('disabled');
//                $('#pre-page').addClass('disabled');
//            }
//            $('#next-page').removeClass('disabled');
//            $('#final-page').removeClass('disabled');
//        }
//    };
//
//    $scope.nextPage = function () {
//        if (!$('#next-page').hasClass('disabled')) {
//            $scope.currentPage++;
//            getParent();
//            if ($scope.currentPage == totalPage - 1) {
//                $('#next-page').addClass('disabled');
//                $('#final-page').addClass('disabled');
//            }
//            $('#first-page').removeClass('disabled');
//            $('#pre-page').removeClass('disabled');
//        }
//    };
//
//    $scope.finalPage = function () {
//        if (!$('#final-page').hasClass('disabled')) {
//            $scope.currentPage = totalPage - 1;
//            getParent();
//            $('#next-page').addClass('disabled');
//            $('#final-page').addClass('disabled');
//            $('#first-page').removeClass('disabled');
//            $('#pre-page').removeClass('disabled');
//        }
//    };
//////////////////////////////////////////////////////////////////
//Show Modal Student /////////////////////////////////////////////
    $scope.clickStudent = function () {
        $('#complete-student-advise').modal('show');
    };
//////////////////////////////////////////////////////////////////




//Download files/////////////////////////////////////////////////
    $scope.dowloads = function (advises) {
        location.href = '/getfileadvise/' + advises.fileUpload.id;

    };
    $scope.file;
    $scope.saveFileAdvise = function () {
        var fd = new FormData();
        fd.append('files', $scope.file);
        $http.post('/savefileadvise', fd, {
            transformRequest: angular.identity,
            headers: {'Content-Type': undefined}
        }).success(function (data) {
            console.log(data + 'fileeeeeeeeeeeeee');
            $scope.advise.fileUpload = data;
        });
    };
/////////////////////////////////////////////////////////////////

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