angular.module('teacher', []);
angular.module('teacher').controller('teacherController', function (UserService ,$scope, $http) {

    $scope.teacher = UserService.user;
    $scope.teachererror = {};

    $scope.saveTeacher = function () {
        $http.post('/saveteacher', $scope.teacher).success(function (data) {
            checkPasswordTeacher();
            $('#complete-dialog-saveteacher').modal('show');
            getTeacher();    
            console.log(data);
            $scope.clear();
            $scope.clearUser();
//            location.href = '#/user_show';
        }).error(function (data) {
            $scope.teachererror = data;
        });
    };

    $scope.clear = function () {
        $scope.teacher = {};
        UserService.user = {};
    };
    
    $scope.checkPasswordTeacher = function () {
        checkPasswordTeacher();
    };
    function checkPasswordTeacher() {
        if (!!$scope.password && !!$scope.teacher.password) {
            if (($scope.password == $scope.teacher.password)) {
                $('#confirm').removeClass('mdi-content-clear').addClass('mdi-action-done').css('color', 'green');
                return true;
            }
            if ($scope.password != $scope.teacher.password) {
                $('#confirm').removeClass('mdi-action-done').addClass('mdi-content-clear').css('color', 'red');
                return false;
            }
        }
        else {
            $('#confirm').removeClass('mdi-content-clear , mdi-action-done');
        }
    }
    
    
    $scope.delTeacher = {};
    $scope.deleteTeacher = function (delteacher) {
        $http.post('/deleteteacher', delteacher).success(function (data) {
            getTeacher();
        }).error(function (data) {
            getError();
        });
    };
    
    getTeacher();


    $scope.teachershow = {};
    function getTeacher() {
        $http.get('/teacher').success(function (data) {
            $scope.teachershow = data;
        }).error(function (data) {

        });
    }
    ;

    $scope.clickUpdate = function (updateTeacher) {
        $scope.teacher = updateTeacher;
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
});