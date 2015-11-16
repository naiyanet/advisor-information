    angular.module('course_subject_2_term2', []);
    angular.module('course_subject_2_term2').controller('course_subject_2_term2Controller', function ($scope, $http) {

    $scope.CourseSubjectClassTwoTermTwo = {};



        $scope.saveCourseSubjectClassTwoTermTwo = function(){
            $http.post('/savecoursesubjectclasstwotermtwo',$scope.CourseSubjectClassTwoTermTwo).success(function (data) {
                getSuccess();
                getCourseSubjectClassTwoTermTwo();
                console.log(data);
                $scope.clear();
            }).error(function (data){
                getError();
            });

        };

        $scope.clear = function () {
            $scope.CourseSubjectClassTwoTermTwo = {};
        };

        $scope.deleteClassTwoTermTwo = function (delSubjecttwo){
            $http.post('/deletecoursesubjectclasstwotermtwo',delSubjecttwo).success(function(){
                getCourseSubjectClassTwoTermTwo();
            }).error(function (data){
                alert('ลบไม่สำเร็จ');
            });
        };


        getCourseSubjectClassTwoTermTwo();


            $scope.courseSubjectClassTwoTermTwoshow = {};
            function getCourseSubjectClassTwoTermTwo(){
                $http.get('/getcoursesubjectclasstwotermtwo').success(function(data){
                    $scope.courseSubjectClassTwoTermTwoshow = data;
                }).error(function(data){

                });
            };


        $scope.clickUpdate = function(updateCourseSubjectClassTwoTermTwo){
            $scope.CourseSubjectClassTwoTermTwo = updateCourseSubjectClassTwoTermTwo;
        };



        function getSuccess(){
            alert('Save Success');
        }
        function getError(){
            alert('Error');
        }
    });