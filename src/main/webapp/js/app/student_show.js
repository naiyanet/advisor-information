angular.module('studentshow', []);

angular.module('studentshow').controller('studentshowController', function ($scope, $http) {

    $scope.account = {};
    $scope.parentShow = {};
    

    $scope.saveStudent = function () {
        $http.post('/savestudent', $scope.account).success(function (data) {
            getSuccess();
            getStudent();
            console.log(data);
            $scope.clear();
        }).error(function (data) {
            getError();
        });
    };

    $scope.clear = function () {
        $scope.account = {};
    };

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
            // console.log(data.content[0]+'-----------gddrgdgdggdg--------');
        }).error(function (data) {
        });
    }
    ;

    getAccountLogin();
    function getAccountLogin() {
        $http.get('/startpageuser').success(function (data) {
            $scope.account = data;
            console.log(data);
        });
    }

    $scope.clickUpdate = function (updateStudent) {
        $scope.account = updateStudent;
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

