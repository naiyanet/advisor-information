angular.module('timetable',[]);
angular.module('timetable').controller('timetableController',function($scope,$http){
    
    $scope.timetable = {};
    $scope.timetableshow = {};
    $scope.timeA = [];
    $scope.acc = {};
    $scope.AllStudentTeacher = {};
    $scope.timetableAll = {};
    var timetable = new Timetable();

    function getAllStudentTeacher() {
        var allST = {};
        if ($scope.acc.dtype === 'Teacher') {
            allST = $scope.acc.id;
        } else {
            allST = $scope.acc.id;
        }
        $http.post('/getAll', allST).success(function (data) {
            $scope.AllStudentTeacher = data;
        });
    }

    $scope.checkTeacherOrStudentLogin = function () {
        if (($scope.acc.dtype === 'Teacher') || ($scope.acc.dtype === 'Student')) {
            $scope.timetable.account = $scope.acc;
            return true;
        }
        else {
            $scope.timetable.account = $scope.acc;
            return false;
        }
    };

    getAccountLogin();
    function getAccountLogin() {
        $http.get('/startpageuser').success(function (data) {
            $scope.acc = data;
            getTimetable();
            getAllStudentTeacher();
//            console.log($scope.acc);
        });
    }

    $scope.saveTimetable = function () {
        var tt = 0;
        for (var i = 0; i < $scope.timetableshow.content.length; i++)
        {
            console.log($scope.timetable.day+i);//วันที่จะ save
            console.log($scope.timetableshow.content[i].day+i);//วันที่มีอยู่
            if (($scope.timetable.day == $scope.timetableshow.content[i].day)&&($scope.timetable.startT == $scope.timetableshow.content[i].startT))
            {
                tt = 1;
            }
        }
        if (tt == 0)
        {
            $http.post('/savetimetable', $scope.timetable).success(function (data) {
                getTimetable();
                $scope.clearData();
                $('#complete-dialog-savetablesuccess').modal('show');
            }).error(function (data) {
                getError();
            });
        } else {
            $('#complete-dialog-savetable').modal('show');
//            alert("วันและเวลาซ้ำซ้อน");
        }

    };


    $scope.delTimetable = function (rowtimetable) {
        $http.post('/deletetimetable', rowtimetable).success(function (data) {
            getTimetable();
        }).error(function (data) {
            alert('ลบไม่สำเร็จ');
        });
    };


    getTimetable();
    function getTimetable() {
        var gettimeForAccount = {};
        gettimeForAccount.searchBy = $scope.acc.dtype;
        gettimeForAccount.keyWord = $scope.acc.name;
        $http.post('/timetable', gettimeForAccount).success(function (data) {
            $scope.timetableshow = data;
            for (var i = 0; i < $scope.timetableshow.content.length; i++)
            {
                timetable.addEvent($scope.timetableshow.content[i].idSubjects + "  :  " + $scope.timetableshow.content[i].subjects, $scope.timetableshow.content[i].day, new Date(2015, 7, 17, $scope.timetableshow.content[i].startT, $scope.timetableshow.content[i].startTm), new Date(2015, 7, 17, $scope.timetableshow.content[i].endT, $scope.timetableshow.content[i].endTm));
                var renderer = new Timetable.Renderer(timetable);
                renderer.draw('.timetable');
            }
        }).error(function (data) {

        });
    }
    ;


    $('.selectpicker').selectpicker({
        style: 'btn-primary'
    });

    $scope.clickUpdate = function (updateTimetable) {
        $scope.timetable = updateTimetable;
    };

    $scope.clearData = function () {
        $scope.timetable = {};
    };


    function getSuccess() {
        alert('Save Success');
    }
    function getError() {
        alert('Error');
    }

    var timetable = new Timetable();

    timetable.setScope(8, 22);

    timetable.addLocations(['Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday', 'Sunday']);





    (function (b, o, i, l, e, r) {
        b.GoogleAnalyticsObject = l;
        b[l] || (b[l] =
                function () {
                    (b[l].q = b[l].q || []).push(arguments)
                });
        b[l].l = +new Date;
        e = o.createElement(i);
        r = o.getElementsByTagName(i)[0];
        e.src = '//www.google-analytics.com/analytics.js';
        r.parentNode.insertBefore(e, r)
    }(window, document, 'script', 'ga'));
    ga('create', 'UA-37417680-5');
    ga('send', 'pageview');
    
    
});