angular.module('add_user', []);
angular.module('add_user').controller('add_userController', function (UserService, $scope, $http) {

    $scope.keyword = "";
    $scope.user = {};
    $scope.page = 0;
    $scope.size = '10';
    var totalRow = 0;
    var totalPage = 0;

    $scope.saveUser = function () {
        $http.post('/saveuser', $scope.user).success(function (data) {
            getSuccess();
            getUser();
        });
    };

    $scope.edit = function (u) {
        if (u.dtype == 'Teacher') {
            location.href = '#/teacher';
            UserService.user = u;
        }
        if (u.dtype == 'Student') {
            location.href = '#/student';
            UserService.user = u;
        }
        if (u.dtype == 'Parent') {
            location.href = '#/parent';
            UserService.user = u;
        }
    };

    $scope.delUser = {};
    $scope.deleteUser = function (delUser) {
        $http.post('/deleteuser', delUser.id).success(function (data) {
            getUser();
            alert("ต้องการลบ");
        });
    };

    getUser();

    $scope.usershow = {};
    function getUser() {
        $http.get('/getuser',{params: {page: $scope.page, size: $scope.size}}).success(function (data) {
            $scope.usershow = data;
        }).error(function (data) {

        });
    }
    ;

    $scope.clickUpdate = function (updateUser) {
        $scope.user = updateUser;
    };

    $scope.clearUser = function () {
        $scope.user = {};
        $scope.password = "";
        checkPassword();
    };

    $scope.clear = {};
    clearUser = function () {
        $scope.user = {};
        $scope.password = "";
        checkPassword();
    };


    function getSuccess() {
        alert('Save Success');
    }
    function getError() {
        alert('Error');
    }


    $scope.searchUser = function (keyword) {
        console.log(keyword);
        if (!keyword) {
            getUser();
        } else {
            $http.post('/getuser/searchuser', keyword).success(function (data) {
                $scope.usershow = data;
            });
        }
    };

    ///////////////////////////////////////////Paging 
    $scope.selectSizeUser = function () {
        $scope.page = 0;
        getUser();
        getTotalRow();
    };

    getTotalRow();
    function getTotalRow() {
        $http.get('/gettotaluser').success(function (data) {
            totalRow = data;
            findPage();
            if ($scope.page == 0) {
                $('#prepageuser , #firstpageuser').addClass('disabled');
            }
            if ($scope.page == totalPage - 1) {
                $('#nextpageuser , #finalpageuser').addClass('disabled');
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
    
    $scope.firstPageUser = function () {
        if (!$('#-page').hasClass('disabled')) {
            $scope.page = 0;
            getUser();
            $('#firstpageuser').addClass('disabled');
            $('#prepageuser').addClass('disabled');
            $('#nextpageuser').removeClass('disabled');
            $('#finalpageuser').removeClass('disabled');
        }
    };

    $scope.prePageUser = function () {
        if (!$('#prepageuser').hasClass('disabled')) {
            $scope.page--;
            getUser();
            if ($scope.page == 0) {
                $('#firstpageuser').addClass('disabled');
                $('#prepageuser').addClass('disabled');
            }
            $('#nextpageuser').removeClass('disabled');
            $('#finalpageuser').removeClass('disabled');
        }
    };

    $scope.nextPageUser = function () {
        if (!$('#nextpageuser').hasClass('disabled')) {
            $scope.page++;
            getUser();
            if ($scope.page == totalPage - 1) {
                $('#nextpageuser').addClass('disabled');
                $('#finalpageuser').addClass('disabled');
            }
            $('#firstpageuser').removeClass('disabled');
            $('#prepageuser').removeClass('disabled');
        }
    };

    $scope.finalPageUser = function () {
        if (!$('#finalpageuser').hasClass('disabled')) {
            $scope.page = totalPage - 1;
            getUser();
            $('#nextpageuser').addClass('disabled');
            $('#finalpageuser').addClass('disabled');
            $('#firstpageuser').removeClass('disabled');
            $('#prepageuser').removeClass('disabled');
        }
    };
    
    
    //////////////////////////////////////////////////////////
});