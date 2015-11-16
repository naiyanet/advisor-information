angular.module('course_subject_1_term2', []);
angular.module('course_subject_1_term2').controller('course_subject_1_term2Controller', function ($scope, $http) {

$scope.CourseSubjectClassOneTermTwo = {};
    
    
    
    $scope.saveCourseSubjectClassOneTermTwo = function(){
        $http.post('/savecoursesubjectclassonetermtwo',$scope.CourseSubjectClassOneTermTwo).success(function (data) {
            getSuccess();
            getCourseSubjectClassOneTermTwo();
            console.log(data);
            $scope.clear();
        }).error(function (data){
            getError();
        });
        
    };
      
    $scope.clear = function () {
        $scope.CourseSubjectClassOneTermTwo = {};
    };
    
    $scope.deleteClassOneTermTwo = function (delSubjectone){
        $http.post('/deletecoursesubjectclassonetermtwo',delSubjectone).success(function(){
            getCourseSubjectClassOneTermTwo();
        }).error(function (data){
            alert('ลบไม่สำเร็จ');
        });
    };
    
    
    getCourseSubjectClassOneTermTwo();
    
    
        $scope.courseSubjectClassOneTermTwoshow = {};
        function getCourseSubjectClassOneTermTwo(){
            $http.get('/getcoursesubjectclassonetermtwo').success(function(data){
                $scope.courseSubjectClassOneTermTwoshow = data;
            }).error(function(data){
                
            });
        };
    

    $scope.clickUpdate = function(updateCourseSubjectClassOneTermTwo){
        $scope.CourseSubjectClassOneTermTwo = updateCourseSubjectClassOneTermTwo;
    };
    
    
    
    function getSuccess(){
        alert('Save Success');
    }
    function getError(){
        alert('Error');
    }
});