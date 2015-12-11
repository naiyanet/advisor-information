angular.module('student', []);

angular.module('student').controller('studentController', function (UserService, $scope, $http) {

    $scope.student = UserService.user;
    $scope.teacherShow = UserService.user.teacher;
    $scope.parentShow = UserService.user.parent;
    $scope.keyword = "";
    $scope.currentPage = 0;
    var page = 0;
    var totalParent = 0;
    var totalPage = 0;
    
    $scope.studenterror = {};
    
    $scope.saveStudent = function () {
            $http.post('/savestudent', $scope.student).success(function (data) {
            getSuccess();
            checkPassword();
            getStudent();
//            location.href = '#/user_show';
            console.log(data);
            $scope.clear();
            $scope.clearUser();
        }).error(function (data) {
            $scope.studenterror = data;
        });
    };

    $scope.clear = function () {
        $scope.student = {};
        $scope.teacherShow = {};
        $scope.parentShow = {};
        UserService.user = {};
    };
    
    
    $scope.checkPassword = function () {
        checkPassword();
    };
    function checkPassword() {
        if (!!$scope.password && !!$scope.student.password) {
            if (($scope.password == $scope.student.password)) {
                $('#confirm').removeClass('mdi-content-clear').addClass('mdi-action-done').css('color', 'green');
                return true;
            }
            if ($scope.password != $scope.student.password) {
                $('#confirm').removeClass('mdi-action-done').addClass('mdi-content-clear').css('color', 'red');
                return false;
            }
        }
        else {
            $('#confirm').removeClass('mdi-content-clear , mdi-action-done');
        }
    }
    
    
    $scope.delStudent = {};
    $scope.deleteStudent = function (delstudent) {
        $http.post('/deletestudent', delstudent).success(function (data) {
            getStudent();
        }).error(function (data) {
            getError();
        });
    };

    getStudent();

    $scope.students = {};
    function getStudent() {
        $http.get('/getstudent').success(function (data) {
            $scope.students = data;
            console.log(data+'---------------------------');
        }).error(function (data) {
        });
    }
    ;
    
    getTeacher();
    $scope.teacher = {};
    function getTeacher() {
        $http.post('/getteacher', 'Teacher').success(function (data) {
            $scope.teacher = data;
        });
    };
    $scope.selectTeacher = function (teacher) {
        $scope.student.teacher = teacher;
        $scope.teacherShow = teacher;
    };
    

    getParent();
    $scope.parent = {};
    function getParent() {
        $http.post('/getparent', 'Parent', {params: {page: $scope.currentPage, size: 10}}).success(function (data) {
            console.log(data + '...............');
            $scope.parent = data;
       }).error(function (data) {

        });
    }
    ;

    $scope.selectParent = function (parent) {
        $scope.student.parent = parent;
        $scope.parentShow = parent;
    };

    $scope.parentSearch = function () {
        console.log($scope.keyword);
        $http.post('/parent/search', $scope.keyword).success(function (data) {
            $scope.parent = data;
            console.log(data);
        });
    };

    countParent();
    function countParent() {
        $http.get('/countparent').success(function (data) {
            totalParent = data;
            console.log(data);
            totalPageParent();
            console.log(totalPage);
        });

        function totalPageParent() {
            totalPage = parseInt(totalParent / 10);
            if ((totalParent % 10) != 0) {
                totalPage++;
            }
            if ($scope.currentPage == 0) {
                $('#first-page').addClass('disabled');
                $('#pre-page').addClass('disabled');
                $('#next-page').addClass('disabled');
                $('#final-page').addClass('disabled');
            }
            if (totalPage > 1) {
                $('#next-page').removeClass('disabled');
                $('#final-page').removeClass('disabled');
            }
        }
    }

    $scope.firstPage = function () {
        if (!$('#first-page').hasClass('disabled')) {
            $scope.currentPage = 0;
            getParent();
            $('#first-page').addClass('disabled');
            $('#pre-page').addClass('disabled');
            $('#next-page').removeClass('disabled');
            $('#final-page').removeClass('disabled');
        }
    };

    $scope.prePage = function () {
        if (!$('#pre-page').hasClass('disabled')) {
            $scope.currentPage--;
            getParent();
            if ($scope.currentPage == 0) {
                $('#first-page').addClass('disabled');
                $('#pre-page').addClass('disabled');
            }
            $('#next-page').removeClass('disabled');
            $('#final-page').removeClass('disabled');
        }
    };

    $scope.nextPage = function () {
        if (!$('#next-page').hasClass('disabled')) {
            $scope.currentPage++;
            getParent();
            if ($scope.currentPage == totalPage - 1) {
                $('#next-page').addClass('disabled');
                $('#final-page').addClass('disabled');
            }
            $('#first-page').removeClass('disabled');
            $('#pre-page').removeClass('disabled');
        }
    };

    $scope.finalPage = function () {
        if (!$('#final-page').hasClass('disabled')) {
            $scope.currentPage = totalPage - 1;
            getParent();
            $('#next-page').addClass('disabled');
            $('#final-page').addClass('disabled');
            $('#first-page').removeClass('disabled');
            $('#pre-page').removeClass('disabled');
        }
    };


    $scope.clickUpdate = function (updateStudent) {
        $scope.student = updateStudent;
    };


    $scope.clearUser = function () {
        $scope.user = {};
        $scope.password = "";
        checkPassword();
    };

    function getSuccess() {
        alert('Save Success');
    }
    function getError() {
        alert('Error');
    }


  $scope.clickParent = function (){
      $('#complete-dialog').openModal();
  };
});




    
