
$('document').ready(function(){
    $('.editButton').on('click', function(event){
        event.preventDefault();	

        var href = $(this).attr('href')
        $.get(href, function(jobtitle, status){
            $('#idEdit').val(jobtitle.id)
            $('#descriptionEdit').val(jobtitle.description)
            $('#detailsEdit').val(jobtitle.details)
        })

        $('#editModal').modal()
    });

    $('.detailsButton').on('click',function(event) {
		event.preventDefault();		
		var href= $(this).attr('href');		
		$.get(href, function(jobtitle, status){
			$('#idDetails').val(jobtitle.id)
            $('#descriptionDetails').val(jobtitle.description)
            $('#detailsDetails').val(jobtitle.details)
			$('#lastModifiedByDetails').val(jobtitle.lastModifiedBy);
			$('#lastModifiedDateDetails').val(jobtitle.lastModifiedDate.substr(0,19).replace("T", " "));
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