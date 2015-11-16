angular.module('appointment',[]);
angular.module('appointment').controller('appointmentController',function($scope,$http){
    
    
    
    $scope.appointment = {};
    
    
    
    $scope.save = function(){
        $http.post('/saveappointment',$scope.appointment).success(getSuccess()).error(getError());
    };
    
    
    
    
    $scope.delAppointment= {};
    $scope.deleteAppointment = function (){
        $http.post('/deleteappointment',$scope.appointment).success(getSuccess()).error(getError());
    };
    
    $scope.delAppointment = function (rowappointment) {
        $http.post('/deleteappointment', rowappointment).success(function (data) {
            getAppointment();
        }).error(function (data) {
            alert('ลบไม่สำเร็จ');
        });
    };
    
    getAppointment();
    
    
    
    $scope.appointmentshow = {};
        function getAppointment(){
            $http.get('/getappointment').success(function(data){
                $scope.appointmentshow = data;
            }).error(function(data){
                
            });
        };
    
    
    
    
    $scope.clickUpdate = function(updateAppointment){
        $scope.appointment = updateAppointment;
    };
    
    
    
    function getSuccess(){
        alert('Save Success');
    }
    function getError(){
        alert('Error');
    }
});