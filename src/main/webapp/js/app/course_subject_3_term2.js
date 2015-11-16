angular.module('course_subject_3_term2', []);
angular.module('course_subject_3_term2').controller('course_subject_3_term2Controller', function ($scope, $http) {

$scope.CourseSubjectClassThreeTermTwo = {};
    
    
    
    $scope.saveCourseSubjectClassThreeTermTwo = function(){
        $http.post('/savecoursesubjectclassthreetermtwo',$scope.CourseSubjectClassThreeTermTwo).success(function (data) {
            getSuccess();
            getCourseSubjectClassThreeTermTwo();
            console.log(data);
            $scope.clear();
        }).error(function (data){
            getError();
        });
        
    };
      
    $scope.clear = function () {
        $scope.CourseSubjectClassThreeTermTwo = {};
    };
    
    $scope.deleteClassThreeTermTwo = function (delSubjectthree){
        $http.post('/deletecoursesubjectclassthreetermtwo',delSubjectthree).success(function(){
            getCourseSubjectClassThreeTermTwo();
        }).error(function (data){
            alert('ลบไม่สำเร็จ');
        });
    };
    
    
    getCourseSubjectClassThreeTermTwo();
    
    
        $scope.courseSubjectClassThreeTermTwoshow = {};
        function getCourseSubjectClassThreeTermTwo(){
            $http.get('/getcoursesubjectclassthreetermtwo').success(function(data){
                $scope.courseSubjectClassThreeTermTwoshow = data;
            }).error(function(data){
                
            });
        };
    

    $scope.clickUpdate = function(updateCourseSubjectClassThreeTermTwo){
        $scope.CourseSubjectClassThreeTermTwo = updateCourseSubjectClassThreeTermTwo;
    };
    
    
    
    function getSuccess(){
        alert('Save Success');
    }
    function getError(){
        alert('Error');
    }
});