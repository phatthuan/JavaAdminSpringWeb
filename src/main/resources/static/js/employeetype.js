
$('document').ready(function(){
    $('.editButton').on('click', function(event){
        event.preventDefault();	

        var href = $(this).attr('href')
        $.get(href, function(employeetype, status){
            $('#idEdit').val(employeetype.id)
            $('#descriptionEdit').val(employeetype.description)
            $('#detailsEdit').val(employeetype.details)
        })

        $('#editModal').modal()
    });

    $('.detailsButton').on('click',function(event) {
		event.preventDefault();		
		var href= $(this).attr('href');		
		$.get(href, function(employeetype, status){
			$('#idDetails').val(employeetype.id)
            $('#descriptionDetails').val(employeetype.description)
            $('#detailsDetails').val(employeetype.details)
			$('#lastModifiedByDetails').val(employeetype.lastModifiedBy);
			$('#lastModifiedDateDetails').val(employeetype.lastModifiedDate.substr(0,19).replace("T", " "));
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