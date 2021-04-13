import { Center, Flex, Grid } from '@chakra-ui/react';
import React from 'react';
import BoxCard from './BoxCard';

const BoxItem: React.FC = () => {
  const property = {
    imageUrl: "https://bit.ly/2Z4KKcF",
    imageAlt: "Rear view of modern home with pool",
    beds: 3,
    baths: 2,
    title: "Modern home in city center in the heart of historic Los Angeles",
    formattedPrice: "$1,900.00",
    reviewCount: 34,
    rating: 4,
  }

  return (
    <Flex>
      <Center w="100vw" p={2}>
        <Grid templateColumns="repeat(4, 1fr)" gap={4}>
          <BoxCard />
          <BoxCard />
          <BoxCard />
          <BoxCard />
          <BoxCard />
          <BoxCard />
          <BoxCard />
          <BoxCard />
          <BoxCard />
          <BoxCard />
          <BoxCard />
          <BoxCard />
        </Grid>
      </Center>
    </Flex>
  )
}

export default BoxItem;