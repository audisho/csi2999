// Fill out your copyright notice in the Description page of Project Settings.

#pragma once

#include "CoreMinimal.h"
#include "Components/SkeletalMeshComponent.h"
#include "Test_Sword.generated.h"

/**
 * 
 */
UCLASS()
class PHOENICIA_API UTest_Sword : public USkeletalMeshComponent
{
	GENERATED_BODY()
		var obj;
	var loader = new THREE.JSONLoader();
	loader.load("Test_sword.blend", function(g, m{
		obj = new THREE.Mesh(g,m)
		scene.add(obj)})
};
