angular.module('allteacher', []);
angular.module('allteacher').controller('allteacherController', function (UserService, $scope, $http) {
    getTeachersAll();
    $scope.showteacher = {};
    function getTeachersAll() {
        $http.get('/teacher').success(function (data) {
            $scope.showteacher = data;
        }).error(function (data) {

        });
    };
});