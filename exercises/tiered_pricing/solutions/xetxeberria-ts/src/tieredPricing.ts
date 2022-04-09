export function tieredPricing(licenseAmount: number): number {
  let licensePrice = 299;
  if (licenseAmount >= 3) {
    licensePrice = 239;
  }

  return licensePrice * licenseAmount;
}
