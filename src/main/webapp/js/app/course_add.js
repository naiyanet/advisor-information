angular.module('course', []);
angular.module('course').controller('courseController', function ($scope, $http) {

    getCourseCategory();
    $scope.coursecategoryshow = {};
    $scope.categoryGroup = {};
    $scope.groupShow;
    $scope.selectFreedom = false;
    $scope.select = {};
    $scope.select.categoryCourse = {};

    function getCourseCategory() {
        $http.get('/getcategorycourse').success(function (data) {
            $scope.coursecategoryshow = data;
            console.log(data);
        }).error(function (data) {

        });
    }
    ;

    getCourseAdd();
    $scope.selectCategoryGroup = function () {
        $scope.categoryGroup = $scope.select.categoryCourse.categoryGroupCourse;
        if ($scope.select.categoryCourse.categoryCourseName == 'หมวดวิชาเลือกเสรี') {
            $scope.selectFreedom = true;
        }
        else {
            $scope.selectFreedom = false;
        }
        console.log($scope.selectFreedom);
    };


    $scope.saveCourse = function () {
        $scope.select.categoryCourse = $scope.select.categoryCourse.categoryCourseName;
        if (!$scope.selectFreedom) {
            $scope.select.categoryGroupCourse = $scope.select.categoryGroupCourse.name;
        }
        console.log($scope.select);
        $http.post('/saveselectcategory', $scope.select).success(function (data) {
            getSuccess();
            $scope.clear();
            getCourseAdd();
        }).error(function (){
            getError();
        });
    };

     $scope.editCourse = function (u) {
        $scope.select = u;
     };



    $scope.clear = function () {
        $scope.select = {};
    };

    $scope.deleteCourse = function (del) {
        console.log(del);
        $http.post('/deleteselectcategory', del).success(function (data) {
            console.log('delete Success');
             var dataLength = $(data.content).length;
            var courseSocialArray = 0;
            var courseLanguageArray = 0;
            var courseMathArray = 0;
            var courseActivityArray = 0;
            var courseBasicArray = 0;
            var courseForceArray = 0;
            var courseChoiceArray = 0;
            var courseFreedomeArray = 0;
 
            for (i = 0; i < dataLength; i++) {
                if (data.content[i].categoryGroupCourse == 'กลุ่มวิชาสังคมศาสตร์และมนุษย์ศาสตร์') {
                    $scope.courseSocial[courseSocialArray++] = data.content[i];
                 }
                if (data.content[i].categoryGroupCourse == 'กลุ่มวิชาภาษา') {
                    $scope.courseLanguage[courseLanguageArray++] = data.content[i];
                }
                if (data.content[i].categoryGroupCourse == 'กลุ่มวิชาวิทยาศาสตร์และคณิตศาสตร์') {
                    $scope.courseMath[courseMathArray++] = data.content[i];
                }
                if (data.content[i].categoryGroupCourse == 'กลุ่มวิชาพลศึกษาหรือนันทนาการหรือกิจกรรม') {
                    $scope.courseActivity[courseActivityArray++] = data.content[i];
                }
                if (data.content[i].categoryGroupCourse == 'กลุ่มวิชาชีพพื้นฐาน') {
                    $scope.courseBasic[courseBasicArray++] = data.content[i];
                 }
                if (data.content[i].categoryGroupCourse == 'กลุ่มวิชาชีพบังคับ') {
                    $scope.courseForce[courseForceArray++] = data.content[i];
                }
                if (data.content[i].categoryGroupCourse == 'กลุ่มวิชาชีพเลือก') {
                    $scope.courseChoice[courseChoiceArray++] = data.content[i];
                }
                if (data.content[i].categoryCourse == 'หมวดวิชาเลือกเสรี') {
                    $scope.courseFreedome[courseFreedomeArray++] = data.content[i];
                 }

            }
        }).error(function (data) {
            getError();
        });
        getCourseAdd();
    };
    
    
    function getSuccess() {
        alert('Save Success');
    }
    function getError() {
        alert('Error');
    }
    
    
    
    //======================================================================================================
    $scope.courseSocial = [];
    $scope.courseLanguage = [];
    $scope.courseMath = [];
    $scope.courseActivity = [];

    $scope.courseBasic = [];
    $scope.courseForce = [];
    $scope.courseChoice = [];

    $scope.courseFreedome = [];


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
 
            for (i = 0; i < dataLength; i++) {
                if (data.content[i].categoryGroupCourse == 'กลุ่มวิชาสังคมศาสตร์และมนุษย์ศาสตร์') {
                    $scope.courseSocial[courseSocialArray++] = data.content[i];
                 }
                if (data.content[i].categoryGroupCourse == 'กลุ่มวิชาภาษา') {
                    $scope.courseLanguage[courseLanguageArray++] = data.content[i];
                }
                if (data.content[i].categoryGroupCourse == 'กลุ่มวิชาวิทยาศาสตร์และคณิตศาสตร์') {
                    $scope.courseMath[courseMathArray++] = data.content[i];
                }
                if (data.content[i].categoryGroupCourse == 'กลุ่มวิชาพลศึกษาหรือนันทนาการหรือกิจกรรม') {
                    $scope.courseActivity[courseActivityArray++] = data.content[i];
                }
                if (data.content[i].categoryGroupCourse == 'กลุ่มวิชาชีพพื้นฐาน') {
                    $scope.courseBasic[courseBasicArray++] = data.content[i];
                 }
                if (data.content[i].categoryGroupCourse == 'กลุ่มวิชาชีพบังคับ') {
                    $scope.courseForce[courseForceArray++] = data.content[i];
                }
                if (data.content[i].categoryGroupCourse == 'กลุ่มวิชาชีพเลือก') {
                    $scope.courseChoice[courseChoiceArray++] = data.content[i];
                }
                if (data.content[i].categoryCourse == 'หมวดวิชาเลือกเสรี') {
                    $scope.courseFreedome[courseFreedomeArray++] = data.content[i];
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
