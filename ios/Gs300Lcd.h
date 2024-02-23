
#ifdef RCT_NEW_ARCH_ENABLED
#import "RNGs300LcdSpec.h"

@interface Gs300Lcd : NSObject <NativeGs300LcdSpec>
#else
#import <React/RCTBridgeModule.h>

@interface Gs300Lcd : NSObject <RCTBridgeModule>
#endif

@end
