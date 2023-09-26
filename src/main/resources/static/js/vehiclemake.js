
$('document').ready(function(){
    $('.editButton').on('click', function(event){
        event.preventDefault();	

        var href = $(this).attr('href')
        $.get(href, function(vehiclemake, status){
            $('#idEdit').val(vehiclemake.id)
            $('#descriptionEdit').val(vehiclemake.description)
            $('#detailsEdit').val(vehiclemake.details)
        })

        $('#editModal').modal()
    });

    $('.detailsButton').on('click',function(event) {
		event.preventDefault();		
		var href= $(this).attr('href');		
		$.get(href, function(vehiclemake, status){
			$('#idDetails').val(vehiclemake.id)
            $('#descriptionDetails').val(vehiclemake.description)
            $('#detailsDetails').val(vehiclemake.details)
			$('#lastModifiedByDetails').val(vehiclemake.lastModifiedBy);
			$('#lastModifiedDateDetails').val(vehiclemake.lastModifiedDate.substr(0,19).replace("T", " "));
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