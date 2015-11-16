angular.module('parentshow', []);
angular.module('parentshow').controller('parentshowController', function (UserService , $scope, $http) {

    $scope.parent = {};

    $scope.saveParent = function () {
        $http.post('/saveParent', $scope.parent).success(function (data) {
            getSuccess();
            getParent();
            console.log(data);
            $scope.clear();
        }).error(function (data) {
            getError();
        });
    };

    $scope.clear = function () {
        $scope.parent = {};
    };

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