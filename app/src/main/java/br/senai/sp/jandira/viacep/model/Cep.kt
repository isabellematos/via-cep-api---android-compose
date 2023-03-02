package br.senai.sp.jandira.viacep.model

import com.google.gson.annotations.SerializedName

data class Cep(
    var cep: String,
    var logradouro: String,
    var complemento: String,
    var bairro: String,
    @SerializedName("localidade") var cidade: String, //oq  for localidade no gson eh cidade no objeto
    @SerializedName("uf") var estado: String
)
