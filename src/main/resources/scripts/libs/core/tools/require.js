function require(object) {
    object.forEach((zxy)=>{
        load("plugins/UISystem/scripts/libs/" + zxy)
    })
}