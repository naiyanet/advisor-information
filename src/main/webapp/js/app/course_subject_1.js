angular.module('course_subject_1', []);
angular.module('course_subject_1').controller('course_subject_1Controller', function ($scope, $http) {

    $scope.CourseSubjectClassOne = {};
    $scope.subject = {};
    $scope.error = {};


    $scope.saveCourseSubjectClassOne = function () {
                $http.post('/savecoursesubjectclassone', $scope.CourseSubjectClassOne).success(function (data) {
                    getSuccess();
                    getCourseSubjectClassOne();
                    $scope.clear();
                })            
        .error(function (data){
            getError();
        });
    };


    $scope.clear = function () {
        $scope.CourseSubjectClassOne = {};
    };

    $scope.deleteClassOne = function (delSubjectone) {
        $http.post('/deletecoursesubjectclassone', delSubjectone).success(function () {
            getCourseSubjectClassOne();
        }).error(function (data) {
            alert('ลบไม่สำเร็จ');
        });
    };


    getCourseSubjectClassOne();


    $scope.courseSubjectClassOneshow = {};
    function getCourseSubjectClassOne() {
        $http.get('/getcoursesubjectclassone').success(function (data) {
            $scope.courseSubjectClassOneshow = data;
        }).error(function (data) {

        });
    }
    ;


    $scope.clickUpdate = function (updateCourseSubjectClassOne) {
        $scope.CourseSubjectClassOne = updateCourseSubjectClassOne;
    };



    function getSuccess() {
        alert('Save Success');
    }
    function getError() {
        alert('Error');
    }
});