angular.module('teacher', []);
angular.module('teacher').controller('teacherController', function (UserService ,$scope, $http) {

    $scope.teacher = UserService.user;

    $scope.saveTeacher = function () {
        $http.post('/saveteacher', $scope.teacher).success(function (data) {
            getSuccess();
            getTeacher();
            console.log(data);
            $scope.clear();
        }).error(function (data) {
            getError();
        });
    };

    $scope.clear = function () {
        $scope.teacher = {};
        UserService.user = {};
    };

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