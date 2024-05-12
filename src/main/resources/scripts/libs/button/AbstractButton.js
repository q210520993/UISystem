
load("plugins/UISystem/scripts/libs/core/Modules/Modules.js")
function AbstractButton(name) {
    ModuleData.call(this,name)
    this.unit = []
    this.image = ""
    this.hoverImage = ""
    this.hoverColor = ""
    this.hoverTransparent = ""
    this.clickImage = ""
    this.clickColor = ""
    this.text = ""
    this.textColor = ""
    this.textSize = ""
    this.use = ""
    this.font = ""
}

AbstractButton.prototype = Object.create(ModuleData.prototype)
AbstractButton.prototype.constructor = AbstractButton

AbstractButton.prototype.setModuleID = (str) => {
    this.moduleID = str
    return this
}

AbstractButton.prototype.AddTrigger = (str) => {
    this.unit.push(str)
    return this
}


AbstractButton.prototype.setImage = str => {
    this.image = str
    return this
}

AbstractButton.prototype.getImage = () => this.image

AbstractButton.prototype.setHoverImage = str => {
    this.hoverImage = str
    return this
}

AbstractButton.prototype.getHoverImage = () => this.hoverImage

AbstractButton.prototype.setHoverColor = str => {
    this.hoverColor = str
    return this
}

AbstractButton.prototype.getHoverColor = () => this.hoverColor

AbstractButton.prototype.setHoverTransparent = str => {
    this.hoverTransparent = str
    return this
}

AbstractButton.prototype.getHoverTransparent = () => this.hoverTransparent

AbstractButton.prototype.setClickImage = str => {
    this.clickImage = str
    return this
}

AbstractButton.prototype.getClickImage = () => this.clickImage

AbstractButton.prototype.setClickColor = str => {
    this.clickColor = str
    return this
}

AbstractButton.prototype.getClickColor = () => this.clickColor

AbstractButton.prototype.setText = str => {
    this.text = str
    return this
}

AbstractButton.prototype.getText = () => this.text

AbstractButton.prototype.setTextColor = str => {
    this.textColor = str
    return this
}

AbstractButton.prototype.getTextColor = () => this.textColor

AbstractButton.prototype.setTextSize = str => {
    this.textSize = str
    return this
}

AbstractButton.prototype.getTextSize = () => this.textSize

AbstractButton.prototype.setUse = str => {
    this.use = str
    return this
}

AbstractButton.prototype.getUse = () => this.use

AbstractButton.prototype.setFont = str => {
    this.font = str
    return this
}

AbstractButton.prototype.getFont = () => this.font

AbstractButton.prototype.setModuleID = str => {
    this.moduleID = str
    return this
}

AbstractButton.prototype.getModuleID = () => this.moduleID