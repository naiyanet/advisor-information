angular.module('course_subject_2', []);
angular.module('course_subject_2').controller('course_subject_2Controller', function ($scope, $http) {

$scope.CourseSubjectClassTwo = {};
    
    
    
        $scope.saveCourseSubjectClassTwo = function(){
        $http.post('/savecoursesubjectclasstwo',$scope.CourseSubjectClassTwo).success(function (data) {
            getSuccess();
            getCourseSubjectClassTwo();
            console.log(data);
            $scope.clear();
        }).error(function (data){
            getError();
        });
        
    };
    
  
    $scope.clear = function () {
        $scope.CourseSubjectClassTwo = {};
    };
    
        $scope.deleteClassTwo = function (delSubjecttwo){
        $http.post('/deletecoursesubjectclasstwo',delSubjecttwo).success(function(){
            getCourseSubjectClassTwo();
        }).error(function (data){
            alert('ลบไม่สำเร็จ');
        });
    };
    
    
    getCourseSubjectClassTwo();
    
    
    
    $scope.courseSubjectClassTwoshow = {};
        function getCourseSubjectClassTwo(){
            $http.get('/getcoursesubjectclasstwo').success(function(data){
                $scope.courseSubjectClassTwoshow = data;
            }).error(function(data){
                
            });
        };
    
    
    
    
    $scope.clickUpdate = function(updateCourseSubjectClassTwo){
        $scope.CourseSubjectClassTwo = updateCourseSubjectClassTwo;
    };
    
    
    
    function getSuccess(){
        alert('Save Success');
    }
    function getError(){
        alert('Error');
    }
});