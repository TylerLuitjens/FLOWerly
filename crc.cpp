#include <stdio.h>
#include <iostream>
#include <math.h>

using namespace std

int main(){
	
	return 0;
}

crcFast(uint8_t const message[], int nBytes)
{
    uint8_t data;
    crc remainder = 0;


    // * Divide the message by the polynomial, a byte at a time.
    for (int byte = 0; byte < nBytes; ++byte)
    {
        data = message[byte] ^ (remainder >> (WIDTH - 8));
        remainder = crcTable[data] ^ (remainder << 8);
    }

    // * The final remainder is the CRC.
    return (remainder);

}  



#define POLYNOMIAL 0xD8  /* 11011 followed by 0's */
//uint8_t is an unsigned char, might want to adjust this to take in a string instead
uint8_t crcNaive(uint8_t const message) //This one goes bit by bit rather than byte by byte
{
    uint8_t  remainder;	


    // * Initially, the dividend is the remainder.
    remainder = message;

    // * For each bit position in the message....
    for (uint8_t bit = 8; bit > 0; --bit)
    {
        // * If the uppermost bit is a 1...
        if (remainder & 0x80)
        {
            // * XOR the previous remainder with the divisor.
            remainder ^= POLYNOMIAL;
        }

        // * Shift the next bit of the message into the remainder.
        remainder = (remainder << 1);
    }

     //* Return only the relevant bits of the remainder as CRC.
    return (remainder >> 4);

} 
//source: https://barrgroup.com/Embedded-Systems/How-To/CRC-Calculation-C-Code
source: https://barrgroup.com/Embedded-Systems/How-To/CRC-Calculation-C-Code
