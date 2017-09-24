function handlePopUpRequest(id, xhr, status, args) {
	console.log("id");
	console.log(id);
	if (args.validationFailed) {
		PF(id).jq.effect("shake", {
			times : 5
		}, 100);
	} else {
		PF(id).hide();
	}
}