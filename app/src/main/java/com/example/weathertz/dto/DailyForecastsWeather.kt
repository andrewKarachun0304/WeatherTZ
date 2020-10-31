package com.example.weathertz.dto


import com.google.gson.annotations.SerializedName

data class DailyForecastsWeather(
    @SerializedName("DailyForecasts")
    var dailyForecasts: List<DailyForecast?>? = null,
    @SerializedName("Headline")
    var headline: Headline? = null
) {
    data class DailyForecast(
        @SerializedName("AirAndPollen")
        var airAndPollen: List<AirAndPollen?>? = null,
        @SerializedName("Date")
        var date: String? = null,
        @SerializedName("Day")
        var day: Day? = null,
        @SerializedName("DegreeDaySummary")
        var degreeDaySummary: DegreeDaySummary? = null,
        @SerializedName("EpochDate")
        var epochDate: Int? = null,
        @SerializedName("HoursOfSun")
        var hoursOfSun: Double? = null,
        @SerializedName("Link")
        var link: String? = null,
        @SerializedName("MobileLink")
        var mobileLink: String? = null,
        @SerializedName("Moon")
        var moon: Moon? = null,
        @SerializedName("Night")
        var night: Night? = null,
        @SerializedName("RealFeelTemperature")
        var realFeelTemperature: RealFeelTemperature? = null,
        @SerializedName("RealFeelTemperatureShade")
        var realFeelTemperatureShade: RealFeelTemperatureShade? = null,
        @SerializedName("Sources")
        var sources: List<String?>? = null,
        @SerializedName("Sun")
        var sun: Sun? = null,
        @SerializedName("Temperature")
        var temperature: Temperature? = null
    ) {
        data class AirAndPollen(
            @SerializedName("Category")
            var category: String? = null,
            @SerializedName("CategoryValue")
            var categoryValue: Int? = null,
            @SerializedName("Name")
            var name: String? = null,
            @SerializedName("Type")
            var type: String? = null,
            @SerializedName("Value")
            var value: Int? = null
        )

        data class Day(
            @SerializedName("CloudCover")
            var cloudCover: Int? = null,
            @SerializedName("HasPrecipitation")
            var hasPrecipitation: Boolean? = null,
            @SerializedName("HoursOfIce")
            var hoursOfIce: Int? = null,
            @SerializedName("HoursOfPrecipitation")
            var hoursOfPrecipitation: Int? = null,
            @SerializedName("HoursOfRain")
            var hoursOfRain: Int? = null,
            @SerializedName("HoursOfSnow")
            var hoursOfSnow: Int? = null,
            @SerializedName("Ice")
            var ice: Ice? = null,
            @SerializedName("IceProbability")
            var iceProbability: Int? = null,
            @SerializedName("Icon")
            var icon: Int? = null,
            @SerializedName("IconPhrase")
            var iconPhrase: String? = null,
            @SerializedName("LongPhrase")
            var longPhrase: String? = null,
            @SerializedName("PrecipitationIntensity")
            var precipitationIntensity: String? = null,
            @SerializedName("PrecipitationProbability")
            var precipitationProbability: Int? = null,
            @SerializedName("PrecipitationType")
            var precipitationType: String? = null,
            @SerializedName("Rain")
            var rain: Rain? = null,
            @SerializedName("RainProbability")
            var rainProbability: Int? = null,
            @SerializedName("ShortPhrase")
            var shortPhrase: String? = null,
            @SerializedName("Snow")
            var snow: Snow? = null,
            @SerializedName("SnowProbability")
            var snowProbability: Int? = null,
            @SerializedName("ThunderstormProbability")
            var thunderstormProbability: Int? = null,
            @SerializedName("TotalLiquid")
            var totalLiquid: TotalLiquid? = null,
            @SerializedName("Wind")
            var wind: Wind? = null,
            @SerializedName("WindGust")
            var windGust: WindGust? = null
        ) {
            data class Ice(
                @SerializedName("Unit")
                var unit: String? = null,
                @SerializedName("UnitType")
                var unitType: Int? = null,
                @SerializedName("Value")
                var value: Int? = null
            )

            data class Rain(
                @SerializedName("Unit")
                var unit: String? = null,
                @SerializedName("UnitType")
                var unitType: Int? = null,
                @SerializedName("Value")
                var value: Double? = null
            )

            data class Snow(
                @SerializedName("Unit")
                var unit: String? = null,
                @SerializedName("UnitType")
                var unitType: Int? = null,
                @SerializedName("Value")
                var value: Int? = null
            )

            data class TotalLiquid(
                @SerializedName("Unit")
                var unit: String? = null,
                @SerializedName("UnitType")
                var unitType: Int? = null,
                @SerializedName("Value")
                var value: Double? = null
            )

            data class Wind(
                @SerializedName("Direction")
                var direction: Direction? = null,
                @SerializedName("Speed")
                var speed: Speed? = null
            ) {
                data class Direction(
                    @SerializedName("Degrees")
                    var degrees: Int? = null,
                    @SerializedName("English")
                    var english: String? = null,
                    @SerializedName("Localized")
                    var localized: String? = null
                )

                data class Speed(
                    @SerializedName("Unit")
                    var unit: String? = null,
                    @SerializedName("UnitType")
                    var unitType: Int? = null,
                    @SerializedName("Value")
                    var value: Double? = null
                )
            }

            data class WindGust(
                @SerializedName("Direction")
                var direction: Direction? = null,
                @SerializedName("Speed")
                var speed: Speed? = null
            ) {
                data class Direction(
                    @SerializedName("Degrees")
                    var degrees: Int? = null,
                    @SerializedName("English")
                    var english: String? = null,
                    @SerializedName("Localized")
                    var localized: String? = null
                )

                data class Speed(
                    @SerializedName("Unit")
                    var unit: String? = null,
                    @SerializedName("UnitType")
                    var unitType: Int? = null,
                    @SerializedName("Value")
                    var value: Double? = null
                )
            }
        }

        data class DegreeDaySummary(
            @SerializedName("Cooling")
            var cooling: Cooling? = null,
            @SerializedName("Heating")
            var heating: Heating? = null
        ) {
            data class Cooling(
                @SerializedName("Unit")
                var unit: String? = null,
                @SerializedName("UnitType")
                var unitType: Int? = null,
                @SerializedName("Value")
                var value: Int? = null
            )

            data class Heating(
                @SerializedName("Unit")
                var unit: String? = null,
                @SerializedName("UnitType")
                var unitType: Int? = null,
                @SerializedName("Value")
                var value: Int? = null
            )
        }

        data class Moon(
            @SerializedName("Age")
            var age: Int? = null,
            @SerializedName("EpochRise")
            var epochRise: Int? = null,
            @SerializedName("EpochSet")
            var epochSet: Int? = null,
            @SerializedName("Phase")
            var phase: String? = null,
            @SerializedName("Rise")
            var rise: String? = null,
            @SerializedName("Set")
            var `set`: String? = null
        )

        data class Night(
            @SerializedName("CloudCover")
            var cloudCover: Int? = null,
            @SerializedName("HasPrecipitation")
            var hasPrecipitation: Boolean? = null,
            @SerializedName("HoursOfIce")
            var hoursOfIce: Int? = null,
            @SerializedName("HoursOfPrecipitation")
            var hoursOfPrecipitation: Int? = null,
            @SerializedName("HoursOfRain")
            var hoursOfRain: Int? = null,
            @SerializedName("HoursOfSnow")
            var hoursOfSnow: Int? = null,
            @SerializedName("Ice")
            var ice: Ice? = null,
            @SerializedName("IceProbability")
            var iceProbability: Int? = null,
            @SerializedName("Icon")
            var icon: Int? = null,
            @SerializedName("IconPhrase")
            var iconPhrase: String? = null,
            @SerializedName("LongPhrase")
            var longPhrase: String? = null,
            @SerializedName("PrecipitationIntensity")
            var precipitationIntensity: String? = null,
            @SerializedName("PrecipitationProbability")
            var precipitationProbability: Int? = null,
            @SerializedName("PrecipitationType")
            var precipitationType: String? = null,
            @SerializedName("Rain")
            var rain: Rain? = null,
            @SerializedName("RainProbability")
            var rainProbability: Int? = null,
            @SerializedName("ShortPhrase")
            var shortPhrase: String? = null,
            @SerializedName("Snow")
            var snow: Snow? = null,
            @SerializedName("SnowProbability")
            var snowProbability: Int? = null,
            @SerializedName("ThunderstormProbability")
            var thunderstormProbability: Int? = null,
            @SerializedName("TotalLiquid")
            var totalLiquid: TotalLiquid? = null,
            @SerializedName("Wind")
            var wind: Wind? = null,
            @SerializedName("WindGust")
            var windGust: WindGust? = null
        ) {
            data class Ice(
                @SerializedName("Unit")
                var unit: String? = null,
                @SerializedName("UnitType")
                var unitType: Int? = null,
                @SerializedName("Value")
                var value: Int? = null
            )

            data class Rain(
                @SerializedName("Unit")
                var unit: String? = null,
                @SerializedName("UnitType")
                var unitType: Int? = null,
                @SerializedName("Value")
                var value: Double? = null
            )

            data class Snow(
                @SerializedName("Unit")
                var unit: String? = null,
                @SerializedName("UnitType")
                var unitType: Int? = null,
                @SerializedName("Value")
                var value: Int? = null
            )

            data class TotalLiquid(
                @SerializedName("Unit")
                var unit: String? = null,
                @SerializedName("UnitType")
                var unitType: Int? = null,
                @SerializedName("Value")
                var value: Double? = null
            )

            data class Wind(
                @SerializedName("Direction")
                var direction: Direction? = null,
                @SerializedName("Speed")
                var speed: Speed? = null
            ) {
                data class Direction(
                    @SerializedName("Degrees")
                    var degrees: Int? = null,
                    @SerializedName("English")
                    var english: String? = null,
                    @SerializedName("Localized")
                    var localized: String? = null
                )

                data class Speed(
                    @SerializedName("Unit")
                    var unit: String? = null,
                    @SerializedName("UnitType")
                    var unitType: Int? = null,
                    @SerializedName("Value")
                    var value: Double? = null
                )
            }

            data class WindGust(
                @SerializedName("Direction")
                var direction: Direction? = null,
                @SerializedName("Speed")
                var speed: Speed? = null
            ) {
                data class Direction(
                    @SerializedName("Degrees")
                    var degrees: Int? = null,
                    @SerializedName("English")
                    var english: String? = null,
                    @SerializedName("Localized")
                    var localized: String? = null
                )

                data class Speed(
                    @SerializedName("Unit")
                    var unit: String? = null,
                    @SerializedName("UnitType")
                    var unitType: Int? = null,
                    @SerializedName("Value")
                    var value: Double? = null
                )
            }
        }

        data class RealFeelTemperature(
            @SerializedName("Maximum")
            var maximum: Maximum? = null,
            @SerializedName("Minimum")
            var minimum: Minimum? = null
        ) {
            data class Maximum(
                @SerializedName("Unit")
                var unit: String? = null,
                @SerializedName("UnitType")
                var unitType: Int? = null,
                @SerializedName("Value")
                var value: Int? = null
            )

            data class Minimum(
                @SerializedName("Unit")
                var unit: String? = null,
                @SerializedName("UnitType")
                var unitType: Int? = null,
                @SerializedName("Value")
                var value: Int? = null
            )
        }

        data class RealFeelTemperatureShade(
            @SerializedName("Maximum")
            var maximum: Maximum? = null,
            @SerializedName("Minimum")
            var minimum: Minimum? = null
        ) {
            data class Maximum(
                @SerializedName("Unit")
                var unit: String? = null,
                @SerializedName("UnitType")
                var unitType: Int? = null,
                @SerializedName("Value")
                var value: Int? = null
            )

            data class Minimum(
                @SerializedName("Unit")
                var unit: String? = null,
                @SerializedName("UnitType")
                var unitType: Int? = null,
                @SerializedName("Value")
                var value: Int? = null
            )
        }

        data class Sun(
            @SerializedName("EpochRise")
            var epochRise: Int? = null,
            @SerializedName("EpochSet")
            var epochSet: Int? = null,
            @SerializedName("Rise")
            var rise: String? = null,
            @SerializedName("Set")
            var `set`: String? = null
        )

        data class Temperature(
            @SerializedName("Maximum")
            var maximum: Maximum? = null,
            @SerializedName("Minimum")
            var minimum: Minimum? = null
        ) {
            data class Maximum(
                @SerializedName("Unit")
                var unit: String? = null,
                @SerializedName("UnitType")
                var unitType: Int? = null,
                @SerializedName("Value")
                var value: Int? = null
            )

            data class Minimum(
                @SerializedName("Unit")
                var unit: String? = null,
                @SerializedName("UnitType")
                var unitType: Int? = null,
                @SerializedName("Value")
                var value: Int? = null
            )
        }
    }

    data class Headline(
        @SerializedName("Category")
        var category: String? = null,
        @SerializedName("EffectiveDate")
        var effectiveDate: String? = null,
        @SerializedName("EffectiveEpochDate")
        var effectiveEpochDate: Int? = null,
        @SerializedName("EndDate")
        var endDate: String? = null,
        @SerializedName("EndEpochDate")
        var endEpochDate: Int? = null,
        @SerializedName("Link")
        var link: String? = null,
        @SerializedName("MobileLink")
        var mobileLink: String? = null,
        @SerializedName("Severity")
        var severity: Int? = null,
        @SerializedName("Text")
        var text: String? = null
    )
}