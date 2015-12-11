angular.module('parent', []);
angular.module('parent').controller('parentController', function (UserService, $scope, $http) {

    $scope.parent = UserService.user;
    $scope.parenterror = {};

    $scope.saveParent = function () {
        $http.post('/saveParent', $scope.parent).success(function (data) {
            getSuccess();
            checkPasswordParent();
            getParent();
//            location.href = '#/user_show';
            console.log(data);
            $scope.clear();
            $scope.clearUser();
        }).error(function (data) {
            $scope.parenterror = data;
        });
    };

    $scope.clear = function () {
        $scope.parent = {};
        UserService.user = {};
    };

    $scope.checkPasswordParent = function () {
        checkPasswordParent();
    };

    function checkPasswordParent() {
        if (!!$scope.password && !!$scope.parent.password) {
            if (($scope.password == $scope.parent.password)) {
                $('#confirm').removeClass('mdi-content-clear').addClass('mdi-action-done').css('color', 'green');
                return true;
            }
            if ($scope.password != $scope.parent.password) {
                $('#confirm').removeClass('mdi-action-done').addClass('mdi-content-clear').css('color', 'red');
                return false;
            }
        } else {
            $('#confirm').removeClass('mdi-content-clear , mdi-action-done');
        }
    }

    $scope.delParent = {};
    $scope.deleteParent = function (delparent) {
        $http.post('/deleteparent', delparent).success(function (data) {
            getParent();
        }).error(function (data) {
            getError();
        });
    };


    getParent();


    $scope.parentshow = {};
    function getParent() {
        $http.get('/parent').success(function (data) {
            $scope.parentshow = data;
        }).error(function (data) {
            getError();
        });
    }
    ;

    $scope.clickUpdate = function (updateParent) {
        $scope.parent = updateParent;
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