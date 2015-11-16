angular.module('course_add', []);
angular.module('course_add').controller('course_addController', function ($scope, $http) {


    $scope.courseSocial = [];
    $scope.courseLanguage = [];
    $scope.courseMath = [];
    $scope.courseActivity = [];

    $scope.courseBasic = [];
    $scope.courseForce = [];
    $scope.courseChoice = [];

    $scope.courseFreedome = [];


    getCourseAdd();

    $scope.courseAddshow = {};
    function getCourseAdd() {
        $http.get('/getselectcategory').success(function (data) {
            var dataLength = $(data.content).length;
            var courseSocialArray = 0;
            var courseLanguageArray = 0;
            var courseMathArray = 0;
            var courseActivityArray = 0;
            var courseBasicArray = 0;
            var courseForceArray = 0;
            var courseChoiceArray = 0;
            var courseFreedomeArray = 0;

            console.log(data.content[0]);
            console.log(dataLength);
            for (i = 0; i < dataLength; i++) {
                if (data.content[i].categoryGroupCourse == 'กลุ่มวิชาสังคมศาสตร์และมนุษย์ศาสตร์') {
                    $scope.courseSocial[courseSocialArray++] = data.content[i];
                    console.log(i);
                }
                if (data.content[i].categoryGroupCourse == 'กลุ่มวิชาภาษา') {
                    $scope.courseLanguage[courseLanguageArray++] = data.content[i];
                    console.log(i);
                }
                if (data.content[i].categoryGroupCourse == 'กลุ่มวิชาวิทยาศาสตร์และคณิตศาสตร์') {
                    $scope.courseMath[courseMathArray++] = data.content[i];
                    console.log(i);
                }
                if (data.content[i].categoryGroupCourse == 'กลุ่มวิชาพลศึกษาหรือนันทนาการหรือกิจกรรม') {
                    $scope.courseActivity[courseActivityArray++] = data.content[i];
                    console.log(i);
                }
                if (data.content[i].categoryGroupCourse == 'กลุ่มวิชาชีพพื้นฐาน') {
                    $scope.courseBasic[courseBasicArray++] = data.content[i];
                    console.log(i);
                }
                if (data.content[i].categoryGroupCourse == 'กลุ่มวิชาชีพบังคับ') {
                    $scope.courseForce[courseForceArray++] = data.content[i];
                    console.log(i);
                }
                if (data.content[i].categoryGroupCourse == 'กลุ่มวิชาชีพเลือก') {
                    $scope.courseChoice[courseChoiceArray++] = data.content[i];
                    console.log(i);
                }
                if (data.content[i].categoryCourse == 'หมวดวิชาเลือกเสรี') {
                    $scope.courseFreedome[courseFreedomeArray++] = data.content[i];
                    console.log(i);
                }

            }

        }).error(function (data) {

        getError();
        });
    }
    ;

    function getSuccess() {
        alert('Save Success');
    }
    function getError() {
        alert('Error');
    }
});
