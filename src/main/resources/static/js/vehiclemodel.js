
$('document').ready(function(){
    $('.editButton').on('click', function(event){
        event.preventDefault();	

        var href = $(this).attr('href')
        $.get(href, function(vehiclemodel, status){
            $('#idEdit').val(vehiclemodel.id)
            $('#descriptionEdit').val(vehiclemodel.description)
            $('#detailsEdit').val(vehiclemodel.details)
        })

        $('#editModal').modal()
    });

    $('.detailsButton').on('click',function(event) {
		event.preventDefault();		
		var href= $(this).attr('href');		
		$.get(href, function(vehiclemodel, status){
			$('#idDetails').val(vehiclemodel.id)
            $('#descriptionDetails').val(vehiclemodel.description)
            $('#detailsDetails').val(vehiclemodel.details)
			$('#lastModifiedByDetails').val(vehiclemodel.lastModifiedBy);
			$('#lastModifiedDateDetails').val(vehiclemodel.lastModifiedDate.substr(0,19).replace("T", " "));
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