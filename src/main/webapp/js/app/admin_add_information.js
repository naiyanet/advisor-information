var app = angular.module('admin_add_information', []);
var app = angular.module('admin_add_information').controller('admin_add_informationController', function ($scope, $http) {

    $scope.searchData = {};


    $scope.information = {};

    $scope.saveInfor = function () {
        console.log($scope.information);
        $http.post('/saveinformation', $scope.information).success(function (data) {
            getSuccess();
            getInformation();
            $scope.clear();
        }).error(function (data) {
            getError();
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

    getInformation();

    $scope.informationshow = {};
    function getInformation() {
        $http.get('/getinformation').success(function (data) {
            $scope.informationshow = data;
            console.log(data);
            for (var i = 0; i < data.totalElements; i++) {
                if (!!data.content[i].startTime) {
                    var d = new Date(data.content[i].startTime).setYear(new Date(data.content[i].startTime).getFullYear() + 543);
                    $scope.informationshow.content[i].startTime = moment(d).format('D MMMM YYYY');
                }
            }
        }).error(function (data) {

        });
    }
    ;

    $scope.clickUpdate = function (updateInformation) {
        $scope.information = updateInformation;
    };

    function getSuccess() {
        alert('Save Success');
    }
    function getError() {
        alert('Error');
    }



    $('.datepicker-custom').datepicker({
        changeYear: true,
        yearRange: '-100:+100',
        dateFormat: 'yy-mm-dd'
    });




    $scope.page = {};
    $scope.size = {};

    $scope.search = function () {
        search();
    };

    function search() {
        $scope.searchData.keyWord;
        $http.post('/searchinformation', $scope.searchData, {params: {page: $scope.page, size: $scope.size}})
                .success(function (data) {
                    $scope.information = data;
                    if (!data.content.length) {
                        $("#complete-dialog").modal('show');
                    }
                });
    }

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