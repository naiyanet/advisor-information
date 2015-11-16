angular.module('course_subject_4_term2', []);
angular.module('course_subject_4_term2').controller('course_subject_4_term2Controller', function ($scope, $http) {

$scope.CourseSubjectClassThreeTermTwo = {};
    
    
    
    $scope.saveCourseSubjectClassFourTermTwo = function(){
        $http.post('/savecoursesubjectclassfourtermtwo',$scope.CourseSubjectClassFourTermTwo).success(function (data) {
            getSuccess();
            getCourseSubjectClassFourTermTwo();
            console.log(data);
            $scope.clear();
        }).error(function (data){
            getError();
        });
        
    };
      
    $scope.clear = function () {
        $scope.CourseSubjectClassFourTermTwo = {};
    };
    
    $scope.deleteClassFourTermTwo = function (delSubjectthree){
        $http.post('/deletecoursesubjectclassfourtermtwo',delSubjectthree).success(function(){
            getCourseSubjectClassFourTermTwo();
        }).error(function (data){
            alert('ลบไม่สำเร็จ');
        });
    };
    
    
    getCourseSubjectClassFourTermTwo();
    
    
        $scope.courseSubjectClassFourTermTwoshow = {};
        function getCourseSubjectClassFourTermTwo(){
            $http.get('/getcoursesubjectclassfourtermtwo').success(function(data){
                $scope.courseSubjectClassFourTermTwoshow = data;
            }).error(function(data){
                
            });
        };
    

    $scope.clickUpdate = function(updateCourseSubjectClassFourTermTwo){
        $scope.CourseSubjectClassFourTermTwo = updateCourseSubjectClassFourTermTwo;
    };
    
    
    
    function getSuccess(){
        alert('Save Success');
    }
    function getError(){
        alert('Error');
    }
});