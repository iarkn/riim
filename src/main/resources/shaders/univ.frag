#define HIGHP

// uniform float u_time;
uniform vec3 u_color;

void main()
{
    // TODO
    gl_FragColor = vec4(u_color, 1.0);
}
