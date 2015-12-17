var app = angular.module('admin_add_information', []);
var app = angular.module('admin_add_information').controller('admin_add_informationController', function ($scope, $http) {

    $scope.searchData = {};

    $scope.information = {};
    $scope.page = 0;
    $scope.size = '10';
    var totalRow = 0;
    var totalPage = 0;
    $scope.saveinformationerror = {};
    
    $http.get('/timeoutinformation');

    $scope.saveInformation = function () {
        console.log($scope.information);
        $scope.information.startTime = new Date($scope.information.startTime);
        $http.post('/saveinformation', $scope.information).success(function (data) {
            getInformation();
            $scope.clear();
            $('#complete-dialog-saveinformation').modal('show');
        }).error(function (data) {
            $scope.saveinformationerror = data;
        });
    };

    $scope.editInformation = function (u) {
        $scope.information = u;
    };

    $scope.clear = function () {
        $scope.information = {};
    };

    $scope.delInformation = {};
    $scope.deleteInformation = function (del_information) {
        $http.post('/deleteinformation', del_information.id).success(function (data) {
            getInformation();
        }).error(function (data) {
            getError();
        });
    };

    $scope.delete = {};
    $scope.clickDelete = function (information) {
        $scope.delete = information;
    };

    getInformation();

    $scope.informationshow = {};
    function getInformation() {
        $http.get('/getinformation', {params: {page: $scope.page, size: $scope.size}}).success(function (data) {
            $scope.informationshow = data;
           for (var i = 0; i < data.content.length; i++) {
                console.log(data.totalElements);
                if (data.content[i].startTime !== undefined) {
                    var d = new Date(data.content[i].startTime).setYear(new Date(data.content[i].startTime).getFullYear() + 543);
                    console.log(d + '   --------------------');
                    $scope.informationshow.content[i].startTime = moment(d).format('D MMMM YYYY');
                }
            }
        }).error(function (data) {

        });
    }
    ;


    $scope.clickUpdate = function (updateInformation) {
        $scope.information = updateInformation;
        $scope.information.startTime = new Date(updateInformation.startTime);
        $scope.information.endTime = new Date(updateInformation.endTime);
    };

    function getError() {
        alert('Error');
    }

    ///////////////////////////////////////////Paging 
    $scope.selectSizeInformation = function () {
        $scope.page = 0;
        getInformation();
        getTotalRow();
    };

    getTotalRow();
    function getTotalRow() {
        $http.get('/gettotalinformation').success(function (data) {
            totalRow = data;
            findPage();
            if ($scope.page == 0) {
                $('#prepageinformation , #firstpageinformation').addClass('disabled');
            }
            if ($scope.page == totalPage - 1) {
                $('#nextpageinformation , #finalpageinformation').addClass('disabled');
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

    $scope.firstPageinformation = function () {
        if (!$('#-page').hasClass('disabled')) {
            $scope.page = 0;
            getInformation();
            $('#firstpageinformation').addClass('disabled');
            $('#prepageinformation').addClass('disabled');
            $('#nextpageinformation').removeClass('disabled');
            $('#finalpageinformation').removeClass('disabled');
        }
    };

    $scope.prePageinformation = function () {
        if (!$('#prepageinformation').hasClass('disabled')) {
            $scope.page--;
            getInformation();
            if ($scope.page == 0) {
                $('#firstpageinformation').addClass('disabled');
                $('#prepageinformation').addClass('disabled');
            }
            $('#nextpageinformation').removeClass('disabled');
            $('#finalpageinformation').removeClass('disabled');
        }
    };

    $scope.nextPageinformation = function () {
        if (!$('#nextpageinformation').hasClass('disabled')) {
            $scope.page++;
            getInformation();
            if ($scope.page == totalPage - 1) {
                $('#nextpageinformation').addClass('disabled');
                $('#finalpageinformation').addClass('disabled');
            }
            $('#firstpageinformation').removeClass('disabled');
            $('#prepageinformation').removeClass('disabled');
        }
    };

    $scope.finalPageinformation = function () {
        if (!$('#finalpageinformation').hasClass('disabled')) {
            $scope.page = totalPage - 1;
            getInformation();
            $('#nextpageinformation').addClass('disabled');
            $('#finalpageinformation').addClass('disabled');
            $('#firstpageinformation').removeClass('disabled');
            $('#prepageinformation').removeClass('disabled');
        }
    };


    //////////////////////////////////////////////////////////

    $('.datepicker-custom').datepicker({
        changeYear: true,
        yearRange: '-100:+100',
        dateFormat: 'yy-mm-dd'
    });





    $scope.dowloads = function (information) {
        location.href = '/getfileinformation/' + information.fileUpload.id;

    };

    $scope.file;
    $scope.saveFile = function () {
//        $("#fileupload").val();
//        console.log($("#fileupload").val());
        var fd = new FormData();
        fd.append('files', $scope.file);
        $http.post('/savefile', fd, {
            transformRequest: angular.identity,
            headers: {'Content-Type': undefined}
        }).success(function (data) {
            console.log(data + 'fileeeeeeeeeeeeee');
            $scope.information.fileUpload = data;
        });
    };

});



app.directive('fileModel', function ($parse) {
    return {
        restrict: 'A',
        link: function (scope, element, attrs) {
            var model = $parse(attrs.fileModel);
            var modelSetter = model.assign;
            element.bind('change', function () {
                scope.$apply(function () {
                    modelSetter(scope, element[0].files[0]);
                });
            });
        }
    };
});

app.directive('customOnChange', function () {
    return {
        restrict: 'A',
        link: function (scope, element, attrs) {
            var onChangeHandler = scope.$eval(attrs.customOnChange);
            element.bind('change', onChangeHandler);
        }
    };
});