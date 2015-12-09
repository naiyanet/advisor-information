angular.module('allstudent', []);
angular.module('allstudent').controller('allstudentController', function (UserService, $scope, $http) {
    $scope.account = {};
    $scope.keyword = "";
    $scope.page = 0;
    $scope.size = '10';
    var totalRow = 0;
    var totalPage = 0;

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
        } else {
            studentOrTeacher = $scope.account.teacher.id;
        }
        $http.post('/getstudentall', studentOrTeacher, {params: {page: $scope.page, size: $scope.size}}).success(function (data) {
            $scope.studentOrTeacher = data;
        });
    }
    ;

    $scope.keyword = "";
    $scope.studentSearch = function () {
        $http.post('/student/search', $scope.keyword).success(function (data) {
            $scope.studentOrTeacher = data;
        });
    };


    ///////////////////////////////////////////Paging 
    $scope.selectSizeStudentall = function () {
        $scope.page = 0;
//        getStudentOfteacher();
//        $scope.studentOrTeacher = data;
        getTotalRow();
    };

    getTotalRow();
    function getTotalRow() {
        $http.get('/gettotalstudentall').success(function (data) {
            totalRow = data;
            findPage();
            if ($scope.page == 0) {
                $('#prepage , #firstpage').addClass('disabled');
            }
            if ($scope.page == totalPage - 1) {
                $('#nextpage , #finalpage').addClass('disabled');
            }

        });
    }

    function findPage() {
        var result = parseInt(totalRow / $scope.size);
        if ((totalRow % $scope.size) != 0) {
            result++;
        }
        totalPage = result;
    }

    $scope.firstPageallstudent = function () {
        if (!$('#-page').hasClass('disabled')) {
            $scope.page = 0;
//            getStudentOfteacher();
//            $scope.studentOrTeacher = data;
            $('#firstpage').addClass('disabled');
            $('#prepage').addClass('disabled');
            $('#nextpage').removeClass('disabled');
            $('#finalpage').removeClass('disabled');
        }
    };

    $scope.prePageallstudent = function () {
        if (!$('#prepage').hasClass('disabled')) {
            $scope.page--;
//            getStudentOfteacher();
//            $scope.studentOrTeacher = data;
            if ($scope.page == 0) {
                $('#firstpage').addClass('disabled');
                $('#prepage').addClass('disabled');
            }
            $('#nextpage').removeClass('disabled');
            $('#finalpage').removeClass('disabled');
        }
    };

    $scope.nextPageallstudent = function () {
        if (!$('#nextpage').hasClass('disabled')) {
            $scope.page++;
//            getStudentOfteacher();
//            $scope.studentOrTeacher = data;
            if ($scope.page == totalPage - 1) {
                $('#nextpage').addClass('disabled');
                $('#finalpage').addClass('disabled');
            }
            $('#firstpage').removeClass('disabled');
            $('#prepage').removeClass('disabled');
        }
    };

    $scope.finalPageallstudent = function () {
        if (!$('#finalpage').hasClass('disabled')) {
            $scope.page = totalPage - 1;
//            getStudentOfteacher();
//            $scope.studentOrTeacher = data;
            $('#nextpage').addClass('disabled');
            $('#finalpage').addClass('disabled');
            $('#firstpage').removeClass('disabled');
            $('#prepage').removeClass('disabled');
        }
    };


    //////////////////////////////////////////////////////////



});
