
$('document').ready(function(){
    $('.editButton').on('click', function(event){
        event.preventDefault();	

        var href = $(this).attr('href')
        $.get(href, function(state, status){
            $('#idEdit').val(state.id)
            $('#ddlCountryEdit').val(state.countryid);
            $('#capitalEdit').val(state.capital)
            $('#codeEdit').val(state.code)
            $('#detailsEdit').val(state.details)
            $('#nameEdit').val(state.name)
        })

        $('#editModal').modal()
    });

    $('.detailsButton').on('click',function(event) {
		event.preventDefault();		
		var href= $(this).attr('href');		
		$.get(href, function(state, status){
			$('#idDetails').val(state.id)
            $('#ddlCountryDetails').val(state.countryid);	
            $('#capitalDetails').val(state.capital)
            $('#codeDetails').val(state.code)
            $('#detailsDetails').val(state.details)
            $('#nameDetails').val(state.name)
			$('#lastModifiedByDetails').val(state.lastModifiedBy);
			$('#lastModifiedDateDetails').val(state.lastModifiedDate.substr(0,19).replace("T", " "));
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