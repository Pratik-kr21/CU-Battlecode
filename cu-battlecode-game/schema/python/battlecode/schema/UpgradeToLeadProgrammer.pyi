from __future__ import annotations

import flatbuffers
import numpy as np

import flatbuffers
import typing

uoffset: typing.TypeAlias = flatbuffers.number_types.UOffsetTFlags.py_type

class UpgradeToLeadProgrammer(object):
  @classmethod
  def SizeOf(cls) -> int: ...

  def Init(self, buf: bytes, pos: int) -> None: ...
  def Phantom(self) -> int: ...

def CreateUpgradeToLeadProgrammer(builder: flatbuffers.Builder, phantom: int) -> uoffset: ...

