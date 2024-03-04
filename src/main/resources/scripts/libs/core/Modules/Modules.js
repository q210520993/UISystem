function ModuleData(ModuleName) {

    if (this.constructor === ModuleData) {
        throw new Error("这是一个抽象类，你无法直接使用！")
    }

    this.ModuleName = null
    this.x = ""
    this.y = ""
    this.width = ""
    this.height = ""
    this.color = ""
    this.path = ""
    this.position = ""
    this.filePath = ""
    this.moduleType = ""
    this.transparent = ""
    this.mask = ""


}

ModuleData.prototype.QST = (UnrealModuleData) => {
    UnrealModuleData.ModuleName = this.ModuleName
    UnrealModuleData.x = this.x;
    UnrealModuleData.y = this.y;
    UnrealModuleData.width = this.width;
    UnrealModuleData.height = this.height;
    UnrealModuleData.color = this.color;
    UnrealModuleData.path = this.path;
    UnrealModuleData.position = this.position;
    UnrealModuleData.filePath = this.filePath;
    UnrealModuleData.moduleType = this.moduleType;
    UnrealModuleData.transparent = this.transparent;
    UnrealModuleData.mask = this.mask;
}

ModuleData.prototype.toJavaModule = function(){
    throw new Error("抽象方法，无法直接调用")
}

ModuleData.prototype.setX = function(value){
    this.x = value
    return this
}

ModuleData.prototype.setY = function(value){
    this.y = value
    return this
}

ModuleData.prototype.setWidth = function(value){
    this.width = value
    return this
}

ModuleData.prototype.setHeight = function(value){
    this.height = value
    return this
}

ModuleData.prototype.setImage = function(value){
    this.image = value
    return this
}

ModuleData.prototype.setColor = function(value){
    this.color = value
    return this
}

ModuleData.prototype.setPath = function(value){
    this.path = value
    return this
}

ModuleData.prototype.setPosition = function(value){
    this.position = value
    return this
}

ModuleData.prototype.setFilePath = function(value){
    this.filePath = value
    return this
}

ModuleData.prototype.setModuleType = function(value){
    this.moduleType = value
    return this
}

ModuleData.prototype.builder = (Data) => {
    throw new Error("你必须实现它")
}