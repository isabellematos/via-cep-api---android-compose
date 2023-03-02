package br.senai.sp.jandira.viacep.service

import br.senai.sp.jandira.viacep.model.Cep
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CepRetrofitService {

    //https://viacep.com.br/ws/06626420/json/
    @GET("{cep}/json/")
    fun getCep(@Path("cep") cep: String): Call<Cep> // ele sabe q cep eh o valor a ser substituido, Call = chamar arquivo na model, cep ou qualquer outro


    //https://viacep.com.br/ws/SP/Jandira/silva/json/
    @GET("{estado}/{cidade}/{logradouro}/json/")
    fun getCeps(
        @Path("estado")estado: String,
        @Path("cidade")cidade: String,
        @Path("logradouro")logradouro: String
    ): Call<List<Cep>>

    //https://viacep.com.br/ws/cidade?name=jandira&estado=SP
   // @GET("cidade?name={nome_cidade}&estado={estado}")
   // fun getTeste(
      // @Query nomeCidade: String,
       //@Query estado: String,
    //)
}