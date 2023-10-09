
$('document').ready(function(){
    $('.editButton').on('click', function(event){
        event.preventDefault();	

        var href = $(this).attr('href')
        $.get(href, function(vehicleMovement, status){
            $('#idEdit').val(vehicleMovement.id);
			$('#ddlVehicleEdit').val(vehicleMovement.vehicleid);
			$('#ddlLocation1Edit').val(vehicleMovement.locationid1);
			$('#ddlLocation2Edit').val(vehicleMovement.locationid2);
			
			var date1 = vehicleMovement.date1.substr(0,10);
			var date2 = vehicleMovement.date2.substr(0,10);
			$('#date1Edit').val(date1);
			$('#date2Edit').val(date2);
			$('#remarksEdit').val(vehicleMovement.remarks);
        })

        $('#editModal').modal()
    });

    $('.detailsButton').on('click',function(event) {
		event.preventDefault();		
		var href= $(this).attr('href');		
		$.get(href, function(vehicleMovement, status){
            $('#idDetails').val(vehicleMovement.id);
			$('#ddlVehicleDetails').val(vehicleMovement.vehicleid);
			$('#ddlLocation1Details').val(vehicleMovement.locationid1);
			$('#ddlLocation2Details').val(vehicleMovement.locationid2);
			
			var date1 = vehicleMovement.date1.substr(0,10);
			var date2 = vehicleMovement.date2.substr(0,10);
			$('#date1Details').val(date1);
			$('#date2Details').val(date2);
			$('#remarksDetails').val(vehicleMovement.remarks);
			$('#lastModifiedByDetails').val(vehicleMaintenance.lastModifiedBy);
			$('#lastModifiedDateDetails').val(vehicleMaintenance.lastModifiedDate.substr(0,19).replace("T", " "));
		});			
		$('#detailsModal').modal();		
	});	

    $('.deleteButton').on('click',function(event) {
		event.preventDefault();
		var href = $(this).attr('href');
		$('#delRef').attr('href', href);
		$('#deleteModal').modal();		
	});
});