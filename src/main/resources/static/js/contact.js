
$('document').ready(function(){
    $('.editButton').on('click', function(event){
        event.preventDefault();	

        var href = $(this).attr('href')
        $.get(href, function(contact, status){
            $('#idEdit').val(contact.id)
            $('#emailEdit').val(contact.email)
            $('#firstnameEdit').val(contact.firstname)
            $('#lastnameEdit').val(contact.lastname)
            $('#mobileEdit').val(contact.mobile)
            $('#phoneEdit').val(contact.phone)
            $('#remarksEdit').val(contact.remarks)
        })

        $('#editModal').modal()
    });

    $('.detailsButton').on('click',function(event) {
		event.preventDefault();		
		var href= $(this).attr('href');		
		$.get(href, function(contact, status){
			$('#idDetails').val(contact.id)
            $('#emailDetails').val(contact.email)
            $('#firstnameDetails').val(contact.firstname)
            $('#lastnameDetails').val(contact.lastname)
            $('#mobileDetails').val(contact.mobile)
            $('#phoneDetails').val(contact.phone)
            $('#remarksDetails').val(contact.remarks)
			$('#lastModifiedByDetails').val(contact.lastModifiedBy);
			$('#lastModifiedDateDetails').val(contact.lastModifiedDate.substr(0,19).replace("T", " "));
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