
$('document').ready(function(){
    $('.editButton').on('click', function(event){
        event.preventDefault();	

        var href = $(this).attr('href')
        $.get(href, function(vechiclestatus, status){
            $('#idEdit').val(vechiclestatus.id)
            $('#descriptionEdit').val(vechiclestatus.description)
            $('#detailsEdit').val(vechiclestatus.details)
        })

        $('#editModal').modal()
    });

    $('.detailsButton').on('click',function(event) {
		event.preventDefault();		
		var href= $(this).attr('href');		
		$.get(href, function(vechiclestatus, status){
			$('#idDetails').val(vechiclestatus.id)
            $('#descriptionDetails').val(vechiclestatus.description)
            $('#detailsDetails').val(vechiclestatus.details)
			$('#lastModifiedByDetails').val(vechiclestatus.lastModifiedBy);
			$('#lastModifiedDateDetails').val(vechiclestatus.lastModifiedDate.substr(0,19).replace("T", " "));
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