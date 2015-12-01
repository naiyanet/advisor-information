angular.module('allstudent', []);
angular.module('allstudent').controller('allstudentController', function (UserService, $scope, $http) {
   $scope.account = {};
   
   getAccountLogin();
    function getAccountLogin() {
        $http.get('/startpageuser').success(function (data) {
            $scope.account = data;
            console.log(data);
            getStudentOfteacher();
        });
    }
    
    function getStudentOfteacher() {
        var studentOrTeacher = {};
        if ($scope.account.dtype === 'Teacher') {
            studentOrTeacher = $scope.account.id;
        }
        else {
            studentOrTeacher = $scope.account.teacher.id;
        }
        $http.post('/getstudentall', studentOrTeacher).success(function (data) {
            console.log('00000000000000000000000000000000000000000000000000000' + data);
            $scope.studentOrTeacher = data;
        });
    }
});
