export function tieredPricing(licenseAmount: number): number {
  const licensePrice = 299;
  return licensePrice * licenseAmount;
}
