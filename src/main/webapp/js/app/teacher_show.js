angular.module('teachershow', []);
angular.module('teachershow').controller('teachershowController', function (UserService ,$scope, $http) {

    $scope.teacher = {};

    $scope.saveTeacherShow = function () {
        console.log('save');
        $http.post('/saveteacher', $scope.teacher).success(function (data) {
            getSuccess();
            getTeacher();
            console.log(data);
            $scope.clear();
        }).error(function (data) {
            getError();
        });
    };
    
     getAccountLogin();
    function getAccountLogin (){
        $http.get('/startpageuser').success(function (data){
            $scope.account = data;
            $scope.teacher = data;
        });
    }

    $scope.clear = function () {
        $scope.teacher = {};
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

    function getSuccess() {
        alert('Save Success');
    }
    function getError() {
        alert('Error');
    }
});