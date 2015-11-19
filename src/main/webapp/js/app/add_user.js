angular.module('add_user', []);
angular.module('add_user').controller('add_userController', function (UserService, $scope, $http) {


    $scope.keyword = null;
    $scope.user = {};

    $scope.saveUser = function () {
        $http.post('/saveuser', $scope.user).success(function (data) {
            getSuccess();
            getUser();
         });
    };

    $scope.edit = function (u) {
        if (u.dtype == 'Teacher') {
            location.href = '#/teacher';
            UserService.user = u;
        }
        if (u.dtype == 'Student') {
            location.href = '#/student';
            UserService.user = u;
        }
        if (u.dtype == 'Parent') {
            location.href = '#/parent';
            UserService.user = u;
        }
    };

    $scope.delUser = {};
    $scope.deleteUser = function (delUser) {
        $http.post('/deleteuser', delUser).success(function (data) {
            getUser();
        });
    };

    getUser();

    $scope.usershow = {};
    function getUser() {
        $http.get('/getuser').success(function (data) {
            $scope.usershow = data;
        }).error(function (data) {

        });
    }
    ;

    $scope.clickUpdate = function (updateUser) {
        $scope.user = updateUser;
    };

    $scope.clearUser = function () {
        $scope.user = {};
        $scope.password = "";
        checkPassword();
    };

    $scope.clear = {};
    clearUser = function () {
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


    $scope.searchUser = function (keyword) {
        console.log(keyword);
        if (!keyword) {
            getUser();
        } else {
            $http.post('/getuser/searchuser', keyword).success(function (data) {
                $scope.usershow = data;
            });
        }
    };

});