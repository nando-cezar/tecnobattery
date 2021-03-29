import React from 'react';
import { Button, useColorMode } from '@chakra-ui/react'
import { MoonIcon, SunIcon } from '@chakra-ui/icons';


const ColorMode: React.FC = () => {

  const { colorMode, toggleColorMode } = useColorMode()

  return (
    <Button
      size="md"
      variant="outline"
      aria-label="Options" 
      onClick={toggleColorMode}
      >
      {colorMode === "light" ? <MoonIcon /> : <SunIcon />}
    </Button>
  );
}

export default ColorMode;
