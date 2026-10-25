package com.test.loginapp.data.api

import kotlinx.serialization.Serializable

@Serializable
data class UsersResponse(
    val users: List<User>
)

@Serializable
data class User(
    val id: Int,
    val firstName: String,
    val lastName: String,
    val maidenName: String,
    val age: Int,
    val gender: String,
    val email: String,
    val phone: String,
    val username: String,
    val password: String,
    val birthDate: String,
    val image: String,
    val bloodGroup: String,
    val height: Double,
    val weight: Double,
    val eyeColor: String,
    val hair: Hair,
    val ip: String,
    val address: Address,
    val macAddress: String,
    val university: String,
    val bank: Bank,
    val company: Company
)


@Serializable
data class Hair(
    val color: String,
    val type: String
)
@Serializable
data class Address(
    val address: String,
    val city: String,
    val state: String,
    val stateCode: String,
    val postalCode: String,
    val coordinates: Coordinates,
    val country: String
)

@Serializable
data class Coordinates(
    val lat: Double,
    val lng: Double
)
@Serializable
data class Bank(
    val cardExpire: String,
    val cardNumber: String,
    val cardType: String,
    val currency: String,
    val iban: String
)
@Serializable
data class Company(
    val department: String,
    val name: String,
    val title: String,
    val address: CompanyAddress
)
@Serializable
data class CompanyAddress(
    val address: String,
    val city: String,
    val state: String,
    val stateCode: String
)