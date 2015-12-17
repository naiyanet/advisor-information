/* global moment */
angular.module('appointment', []);
angular.module('appointment').controller('appointmentController', function (UserService, $scope, $http) {

    $scope.appointment = {};

    $scope.startTime = "";
    $scope.endTime = "";

    $scope.account = {};
    $scope.studentShow = UserService.user.student;
    $scope.keyword = "";
    $scope.currentPage = 0;
    var totalPage = 0;

    $scope.studentOfTeacher = {};
    var ev = [];
    $scope.title = '';
    $scope.start = '';
    $scope.end = '';
    
    $scope.saveappointmenterror = {};
    
    $scope.checkTeacherLogin = function () {
        if ($scope.account.dtype === 'Teacher') {
            $scope.appointment.teacher = $scope.account;
            return true;
        } else {
            $scope.appointment.student = $scope.account;
            $scope.appointment.teacher = $scope.account.teacher;
            return false;
        }
    };
    
    $scope.appointmentshowname = function () {
        if ($scope.account.dtype == 'Teacher') {
            return  true;
        } else {
            return false;
        }
    };
    
    getAccountLogin();
    function getAccountLogin() {
        $http.get('/startpageuser').success(function (data) {
            $scope.account = data;
            getAppointment();
            getStudentOfteacher();

        });
    }

    $scope.saveAppointment = function () {
        $scope.appointment.startTime = new Date(moment(new Date($scope.appointment.date + " " + $scope.startTime)).format('YYYY-MM-d HH:mm:ss'));
        $scope.appointment.endTime = new Date(moment(new Date($scope.appointment.date + " " + $scope.endTime)).format('YYYY-MM-d HH:mm:ss'));
        $http.post('/saveappointment', $scope.appointment).success(function (data) {
            $('#complete-dialog-saveappointment').modal('show');
            $scope.clear();
            getAppointment();
        }).error(function (data) {
            $scope.saveappointmenterror = data;
        });
    };

    $scope.editappoint = function (u) {
        $scope.appointment = u;
    };

    $scope.clear = function () {
        $scope.appointment = {};
        $scope.startTime = "";
        $scope.endTime = "";
    };
    
    
    $scope.deleteAppointment = function (appo) {
        $http.post('/delappointment', appo.id).success(function (data) {
            getAppointment();
        }).error(function (data) {
            getError();
        });
    };
$scope.delete = {};
    $scope.clickDelete = function (advise) {
        $scope.delete = advise;
    };
    
    $scope.clickUpdate = function (updateAppointment) {
        $scope.appointment = updateAppointment;
    };
////////////////////////////////////////////////////////////////////////////////
    function getStudentOfteacher() {
        var studentOrTeacher = {};
        if ($scope.account.dtype === 'Teacher') {
            studentOrTeacher = $scope.account.id;
        } else {
            studentOrTeacher = $scope.account.teacher.id;
        }
        $http.post('/getstudentofteacherApp', studentOrTeacher).success(function (data) {
            $scope.studentOfTeacher = data;
        });
    }
    ////////////////////////////////////////////////////////////////////////////
    $scope.appointmentshow = {};
    function getAppointment() {
        var getAppointmentForAccount = {};
        getAppointmentForAccount.searchBy = $scope.account.dtype;
        getAppointmentForAccount.keyWord = $scope.account.name;
        $http.post('/getappointment', getAppointmentForAccount).success(function (data) {
            $scope.appointmentshow = data;
            console.log($scope.appointmentshow+"kkkkkkkkkkkkkkkkkkkkkkkkkkkk");
            ev = new Array($scope.appointmentshow.content.length);
            for (var i = 0; i < ev.length; i++)
            {
                ev[i] = {start: $scope.appointmentshow.content[i].date + "T" + $scope.appointmentshow.content[i].startTime,
                    end: $scope.appointmentshow.content[i].date + "T" + $scope.appointmentshow.content[i].endTime,
                    title: $scope.appointmentshow.content[i].topic};
            }
            $(document).ready(function () {
                $('#fullcalendar').fullCalendar({
                    height: 650,
                    contentHeight: 600,
                    header: {
                        left: 'prev,today,next',
                        center: 'title',
                        right: 'month,agendaWeek,agendaDay'
                    },
                    businessHours: {
                        start: '00:00',
                        end: '24:00',
                        dow: [1, 2, 3, 4, 5, 6]
                    },
                    events:
                            ev,
                    color: 'yellow', // an option!
                    textColor: 'black', // an option!
                    eventClick: function (evClick) {
                        $scope.title = evClick.title;
                        $scope.start = moment(new Date(new Date(evClick.start).getFullYear(), new Date(evClick.start).getMonth(), new Date(evClick.start).getDate()
                                , new Date(evClick.start).getHours() - 7)).format('YYYY-MM-D เวลา HH:mm');
                        $scope.end = moment(new Date(new Date(evClick.end).getFullYear(), new Date(evClick.end).getMonth(), new Date(evClick.end).getDate()
                                , new Date(evClick.end).getHours() - 7)).format('HH:mm');
                        getAppointment();
//                        $scope.appointmentshow = data;
                        $('#modal-showDataEvent').openModal();
                    }
                });
            });
        }).error(function (data) {
            getError();
        });
    };

    ////////////////////////////////////////////////////////////////////////////
    $scope.appointmentSearch = function () {
        $http.post('/searchStudentInAppoint', $scope.keyword).success(function (data) {
            $scope.appointmentshow = data;
        });
    };
    ////////////////////////////////////////////////////////////////////////////search student show
    $scope.selectStudent = function (student) {
        $scope.appointment.student = student;
        $scope.studentShow = student;
    };

    $scope.studentSearch = function () {
        console.log($scope.keyword);
        $http.post('/student/search', $scope.keyword).success(function (data) {
            $scope.student = data;
            console.log(data);
        });
    };

    countStudent();
    function countStudent() {
        $http.get('/countstudent').success(function (data) {
            totalStudent = data;
            totalPageStudent();
            console.log(totalPage);
        });

        function totalPageStudent() {
            totalPage = parseInt(totalStudent / 10);
            if ((totalStudent % 10) != 0) {
                totalPage++;
            }
            if ($scope.currentPage == 0) {
                $('#first-page').addClass('disabled');
                $('#pre-page').addClass('disabled');
                $('#next-page').addClass('disabled');
                $('#final-page').addClass('disabled');
            }
            if (totalPage > 1) {
                $('#next-page').removeClass('disabled');
                $('#final-page').removeClass('disabled');
            }
        }
    }

    $scope.firstPage = function () {
        if (!$('#first-page').hasClass('disabled')) {
            $scope.currentPage = 0;
            getParent();
            $('#first-page').addClass('disabled');
            $('#pre-page').addClass('disabled');
            $('#next-page').removeClass('disabled');
            $('#final-page').removeClass('disabled');
        }
    };

    $scope.prePage = function () {
        if (!$('#pre-page').hasClass('disabled')) {
            $scope.currentPage--;
            getParent();
            if ($scope.currentPage == 0) {
                $('#first-page').addClass('disabled');
                $('#pre-page').addClass('disabled');
            }
            $('#next-page').removeClass('disabled');
            $('#final-page').removeClass('disabled');
        }
    };

    $scope.nextPage = function () {
        if (!$('#next-page').hasClass('disabled')) {
            $scope.currentPage++;
            getParent();
            if ($scope.currentPage == totalPage - 1) {
                $('#next-page').addClass('disabled');
                $('#final-page').addClass('disabled');
            }
            $('#first-page').removeClass('disabled');
            $('#pre-page').removeClass('disabled');
        }
    };

    $scope.finalPage = function () {
        if (!$('#final-page').hasClass('disabled')) {
            $scope.currentPage = totalPage - 1;
            getParent();
            $('#next-page').addClass('disabled');
            $('#final-page').addClass('disabled');
            $('#first-page').removeClass('disabled');
            $('#pre-page').removeClass('disabled');
        }
    };
    $scope.clickStudent = function () {
        $('#complete-student-appointment').modal('show');
    };

    //////////////////////////////////////////////////////////////////////////// get Date
    $('.datepicker-custom').datepicker({
        changeYear: true,
        yearRange: '-100:+100',
        dateFormat: 'yy-mm-dd'
    });
    ///////////////////////////////////////////////////////////////////////////get Time
    $('#time-starttime input').ptTimeSelect({
        onClose: function (i) {
            $scope.startTime = $(i).val() + "";
            var m = moment(new Date($scope.appointment.date + " " + $scope.startTime)).format('YYYY-MM-dd HH:mm:ss') + " ";
            var dd = new Date(moment(new Date('2015-10-09 11:13 PM')).format('EEE, dd MMM YYYY HH:mm:ss zzz'));
            console.log($scope.startTime);
            $('#label-starttime').addClass('active');
            $('#prefix-starttime').addClass('active');
        }
    });

    $('#time-endtime input').ptTimeSelect({
        onClose: function (i) {
            $scope.endTime = $(i).val() + "";
            console.log($scope.endTime);
            $('#label-endtime').addClass('active');
            $('#prefix-endtime').addClass('active');
        }
    });
    ////////////////////////////////////////////////////////////////////////////get Success /get Error

    function getSuccess() {
        alert('Save Success');
    }
    function getError() {
        alert('Error');
    }
    ////////////////////////////////////////////////////////////////////////////
});