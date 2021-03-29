import { extendTheme, theme } from "@chakra-ui/react"

const config: any = {
  initialColorMode: "dark",
  useSystemColorMode: 
  theme, 
  fonts: {
    body: 'Roboto, system-ui, sans-serif',
    heading: 'Roboto, system-ui, sans-serif',
    mono: 'Menlo, monospace'
  },
  fontWeights: {
    ...theme.fontWeights,
    normal: 400,
    medium: 600,
    bold: 700,
  },
  radii: {
    ...theme.radii,
    sm: '5px',
    md: '8px',
  },
  colors: {
    ...theme.colors,
    red: {
      ...theme.colors.red,
      500: '#D73232',
    },
    gray: {
      ...theme.colors.gray,
      300: '#e1e1e6',
      600: '#29292e',
      700: '#202024',
      800: '#121214'
    },
  },
}

const themeChakra = extendTheme({ config })

export default themeChakra