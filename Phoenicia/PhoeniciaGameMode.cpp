// Copyright Epic Games, Inc. All Rights Reserved.

#include "PhoeniciaGameMode.h"
#include "PhoeniciaCharacter.h"

APhoeniciaGameMode::APhoeniciaGameMode()
{
	// Set default pawn class to our character
	DefaultPawnClass = APhoeniciaCharacter::StaticClass();	
}
