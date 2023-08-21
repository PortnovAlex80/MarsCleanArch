package com.marsrover.nasa.common.types.base

abstract class AggregateRoot<T>(id: T, version: Version) : DomainEntity<T>(id, version)